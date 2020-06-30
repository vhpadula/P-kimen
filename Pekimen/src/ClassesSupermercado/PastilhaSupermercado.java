package ClassesSupermercado;

import java.awt.Color;
import java.awt.Graphics;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesTabuleiro.Pastilha;

public class PastilhaSupermercado extends Pastilha {

	public PastilhaSupermercado(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
		this.setImage("Supermercado/pastilha.png");
	}
	
	@Override
	public void render(Graphics g) {
		g.fillRect(30 * x + 15, 21 * y + 10, 5, 5);
		
		super.render(g);
		
		
	}
}
