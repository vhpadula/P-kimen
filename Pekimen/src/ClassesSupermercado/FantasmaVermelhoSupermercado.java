package ClassesSupermercado;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.FantasmaVermelho;

public class FantasmaVermelhoSupermercado extends FantasmaVermelho {

	public FantasmaVermelhoSupermercado(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma,
			int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.up = "Supermercado/fantasmaVermelho.png";
		this.down = "Supermercado/fantasmaVermelho.png";
		this.left = "Supermercado/fantasmaVermelho.png";
		this.right = "Supermercado/fantasmaVermelho.png";
		this.setImage("Supermercado/fantasmaVermelho.png");
	}

}
