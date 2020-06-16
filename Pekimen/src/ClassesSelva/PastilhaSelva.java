package ClassesSelva;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesTabuleiro.Pastilha;

public class PastilhaSelva extends Pastilha{

	public PastilhaSelva(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
		this.setImage("Classic/pastilha.png");
	}
	
}
