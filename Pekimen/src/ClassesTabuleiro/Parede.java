package ClassesTabuleiro;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesGerais.ObjetoJogo;

public abstract class Parede extends ObjetoJogo {

	public Parede(int x, int y, ID id, Controle controle, String cruzamento) throws IOException {
		super(x, y, id, controle, cruzamento);

	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(30 * x, 21 * y, 30, 21);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, 30 * x, 21 * y, 30, 21, null);

	}

}
