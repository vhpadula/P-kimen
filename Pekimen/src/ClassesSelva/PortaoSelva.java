package ClassesSelva;

import java.io.IOException;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesTabuleiro.Portao;

public class PortaoSelva extends Portao {

	public PortaoSelva(int x, int y, ID id, Controle controle, String cruzamento) throws IOException {
		super(x, y, id, controle, cruzamento);
		this.setImage("Selva/gate.png");
	}
}
