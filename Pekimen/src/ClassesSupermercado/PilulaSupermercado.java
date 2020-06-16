package ClassesSupermercado;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesTabuleiro.Pilula;

public class PilulaSupermercado extends Pilula {

	public PilulaSupermercado(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
		this.imagePath = "Classic/pastilha.png";
		this.ajustaTextura();
	}

}
