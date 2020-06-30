package ClassesSupermercado;

import java.awt.Graphics;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesTabuleiro.Ima;

public class ImaSupermercado extends Ima{
	public ImaSupermercado(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
		this.setImage("Classic/ima.png");
	}
	
	@Override
	public void render(Graphics g) {
		g.fillRect(30 * x + 5, 21 * y + 2, 19, 19);
		
		super.render(g);
		
		
	}
}
