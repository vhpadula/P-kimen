package ClassesClassico;

import java.io.IOException;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesTabuleiro.Parede;

public class ParedeClassica extends Parede {

	public ParedeClassica(int x, int y, ID id, Controle controle, String cruzamento) throws IOException {
		super(x, y, id, controle, cruzamento);
		this.setImage("Classic/wall.png");
	}
}
