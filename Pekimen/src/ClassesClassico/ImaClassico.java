package ClassesClassico;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesTabuleiro.Ima;

public class ImaClassico extends Ima {

	public ImaClassico(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
		this.setImage("Classic/ima.png");
	}
}
