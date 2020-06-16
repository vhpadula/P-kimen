package ClassesSupermercado;

import java.io.IOException;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesTabuleiro.Portao;

public class PortaoSupermercado extends Portao {

	public PortaoSupermercado(int x, int y, ID id, Controle controle, String cruzamento) throws IOException {
		super(x, y, id, controle, cruzamento);
		this.setImage("Supermercado/gate.png");
	}

}
