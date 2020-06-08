package ClassesSelva;

import java.io.IOException;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesTabuleiro.Parede;

public class ParedeSelva extends Parede {

	public ParedeSelva(int x, int y, ID id, Controle controle, String cruzamento) throws IOException {
		super(x, y, id, controle, cruzamento);
		this.imagePath = "Selva/terra.png";
		this.ajustaTextura();
	}

}
