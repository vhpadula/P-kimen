package ClassesTabuleiro;

import java.awt.Graphics;
import java.awt.Rectangle;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesGerais.ObjetoJogo;

public class Cruzamento extends ObjetoJogo {
	public Cruzamento(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(30 * x + 15, 21 * y + 10, 3, 3);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, 30 * x + 15, 21 * y + 10, 3, 3, null);

	}

}
