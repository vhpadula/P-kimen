package ClassesSelva;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesTabuleiro.Cereja;

public class CerejaSelva extends Cereja {

	public CerejaSelva(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
		this.imagePath = "Classic/Cereja.png";
		this.ajustaTextura();
	}

}
