package ClassesSupermercado;

import java.awt.Graphics;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesTabuleiro.Cereja;

public class CerejaSupermercado extends Cereja {

	public CerejaSupermercado(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
		this.setImage("Supermercado/cerejaMercado.png");
	}
	@Override
	public void render(Graphics g) {
		g.fillRect(30 * x + 5, 21 * y, 22, 22);
		
		super.render(g);
		
		
	}
}
