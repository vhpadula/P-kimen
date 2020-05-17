import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import java.io.IOException;

public class Jogo extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 856, HEIGHT = 768;

	private Thread thread;

	Janela janela;
	Mapa mapa;
	private boolean running = false;

	private Controle controle;

	public Jogo() throws IOException {
		janela = new Janela(WIDTH, HEIGHT, "PacMan", this);
		controle = new Controle();
		mapa = new Mapa(true, controle);
		
		this.addKeyListener(new KeyInput(controle));
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
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				janela.frame.setTitle("PacMan | " + frames + " fps"); // mostra o fps na janela
				// atualiza o tamanho da janela
				// janela.imagem=
				// janela.imagem.getScaledInstance(janela.frame.getWidth(),janela.frame.getHeight(),
				// Image.SCALE_DEFAULT);
				// janela.frame.setContentPane(new JLabel(new ImageIcon(janela.imagem)));
				frames = 0;
			}
		}
		parar();
	}

	private void tick() {
		controle.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.drawImage(janela.imagem, janela.getWidth(), janela.getHeight(), null);
		controle.render(g);
		g.dispose();
		bs.show();
	}
}
