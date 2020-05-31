import java.awt.Canvas;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import java.io.IOException;

public class Jogo extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 846, HEIGHT = 768;

	private Thread thread;

	Janela janela;
	Mapa mapa;
	private boolean running = false;

	private Controle controle;
	private HUD hud;
	private Menu menu;

	public ESTADO estadoJogo = ESTADO.Menu;

	public Jogo() throws IOException {
		controle = new Controle();
		hud = new HUD();
		janela = new Janela(WIDTH, HEIGHT, "PacMan", this);
		mapa = new Mapa(true, controle, this);
		menu = new Menu(this, controle, mapa);

		this.addMouseListener(menu);
		this.addKeyListener(new KeyInput(controle));
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
				// System.out.println("FPS: " + frames);
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
		} else if (estadoJogo == ESTADO.Menu || estadoJogo == ESTADO.Settings) {
			menu.tick();
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
		} else if (estadoJogo == ESTADO.Menu || estadoJogo == ESTADO.Settings) {
			menu.render(g);
		}

		g.dispose();
		bs.show();
	}
}
