package ClassesTabuleiro;

import java.awt.Graphics;
import java.awt.Rectangle;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesGerais.ObjetoJogo;

public class Pilula extends ObjetoJogo {

	public Pilula(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, 30 * x + 11, 21 * y + 6, 12, 12, null);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(30 * x + 11, 21 * y + 6, 12, 12);
	}
}
