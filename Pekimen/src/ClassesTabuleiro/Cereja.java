package ClassesTabuleiro;

import java.awt.Graphics;
import java.awt.Rectangle;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesGerais.ObjetoJogo;

public abstract class Cereja extends ObjetoJogo {

	public Cereja(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(30 * x + 5, 21 * y + 5, 20, 20);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, 30 * x + 5, 21 * y + 5, 20, 20, null);

	}

}
