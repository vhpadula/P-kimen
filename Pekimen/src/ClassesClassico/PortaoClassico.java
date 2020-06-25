package ClassesClassico;

import java.io.IOException;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesTabuleiro.Portao;

public class PortaoClassico extends Portao {

	public PortaoClassico(int x, int y, ID id, Controle controle, String cruzamento) throws IOException {
		super(x, y, id, controle, cruzamento);
		this.setImage("Classic/gate.png");
	}
}
