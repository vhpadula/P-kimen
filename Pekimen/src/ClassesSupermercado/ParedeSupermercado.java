package ClassesSupermercado;

import java.io.IOException;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesTabuleiro.Parede;

public class ParedeSupermercado extends Parede {

	public ParedeSupermercado(int x, int y, ID id, Controle controle, String cruzamento) throws IOException {
		super(x, y, id, controle, cruzamento);
		this.imagePath = "Supermercado/wall.png";
		this.ajustaTextura();
	}

}
