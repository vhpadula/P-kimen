package ClassesSupermercado;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesTabuleiro.Pastilha;

public class PastilhaSupermercado extends Pastilha {

	public PastilhaSupermercado(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
		this.setImage("Supermercado/pastilha.png");
	}

}
