package ClassesSupermercado;

import java.awt.Graphics;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesTabuleiro.Pilula;

public class PilulaSupermercado extends Pilula {

	public PilulaSupermercado(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
		this.setImage("Supermercado/pastilhaMercado.png");
	}
	
	@Override
	public void render(Graphics g) {
		g.fillRect(30 * x+9, 21 * y+3 , 17, 17);
		
		super.render(g);
		
		
	}
}

