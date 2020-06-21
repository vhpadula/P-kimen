package ClassesGerais;

import java.awt.Canvas;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import ClassesInterface.ESTADO;
import ClassesInterface.GameOver;
import ClassesInterface.HUD;
import ClassesInterface.Janela;
import ClassesInterface.Menu;
import ClassesInterface.Settings;
import ClassesTabuleiro.Mapa;

public class Jogo extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 846, HEIGHT = 768;

	private Thread thread;

	Janela janela;
	Mapa mapa;
	private boolean running = false;
	public  Musica musica;
	private Controle controle;
	private HUD hud;
	private Menu menu;
	private GameOver gameOver;
	private Settings settings;
	public Fabrica fabrica;
	public ESTADO estadoJogo = ESTADO.Menu;

	public Jogo() throws IOException {
		hud = new HUD();
		controle = new Controle(this);
		janela = new Janela(WIDTH, HEIGHT, "PacMan", this);

		fabrica = new FabricaClassica(controle,this);

		mapa = new Mapa(true, controle, this, fabrica);
		menu = new Menu(this, controle, mapa, hud);
		gameOver = new GameOver(hud);
		settings = new Settings();

		this.addMouseListener(menu);
		this.addKeyListener(new KeyInput(controle));
		
		try {
			this.fabrica.fazMusica();
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		}		
	}

	public static int teleporte(int var, int min, int max) {
		if (var >= max)
			return min;
		else if (var <= min)
			return max;
		else
			return var;
	}

	public synchronized void iniciar() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void parar() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocusInWindow();
		long ultimaVez = System.nanoTime();
		double quantidadeDeTicks = 60.0;
		double ns = 1000000000 / quantidadeDeTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - ultimaVez) / ns;
			ultimaVez = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				try {
					render();
				} catch (FontFormatException | IOException e) {
					e.printStackTrace();
				}
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				janela.frame.setTitle("PacMan | " + frames + " fps"); // mostra o fps na janela
				frames = 0;
			}
		}
		parar();
	}

	private void tick() {
		controle.tick();
		
		if (estadoJogo == ESTADO.Jogo) {
			hud.tick();
			if (HUD.vidas == -1) {
				HUD.vidas = 2;
				controle.objetos.clear();
				estadoJogo = ESTADO.End;
			}
		} else if (estadoJogo == ESTADO.Menu || estadoJogo == ESTADO.Settings) {
			menu.tick();
		} else if (estadoJogo == ESTADO.End) {
			gameOver.tick();
		}
	}

	private void render() throws FontFormatException, IOException {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.drawImage(janela.imagem, janela.getWidth(), janela.getHeight(), null);
		controle.render(g);

		if (estadoJogo == ESTADO.Jogo) {
			hud.render(g);
		} else if (estadoJogo == ESTADO.Menu) {
			menu.render(g);
		} else if (estadoJogo == ESTADO.Settings) {
			settings.render(g);
		}
		else if (estadoJogo == ESTADO.End) {
			gameOver.render(g);
		}

		g.dispose();
		bs.show();
	}
}
