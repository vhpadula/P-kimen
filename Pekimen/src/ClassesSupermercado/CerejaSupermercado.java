package ClassesSupermercado;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesTabuleiro.Cereja;

public class CerejaSupermercado extends Cereja {

	public CerejaSupermercado(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
		this.setImage("Supermercado/cerejaMercado.png");
	}
}
