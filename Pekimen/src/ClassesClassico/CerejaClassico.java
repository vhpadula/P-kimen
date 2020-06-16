package ClassesClassico;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesTabuleiro.Cereja;

public class CerejaClassico extends Cereja {

	public CerejaClassico(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
		this.imagePath = "Classic/Cereja.png";
		this.ajustaTextura();
	}

}
