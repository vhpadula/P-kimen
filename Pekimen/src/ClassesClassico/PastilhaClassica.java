package ClassesClassico;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesTabuleiro.Pastilha;

public class PastilhaClassica extends Pastilha {

	public PastilhaClassica(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
		this.imagePath = "Classic/pastilha.png";
		this.ajustaTextura();
	}

}
