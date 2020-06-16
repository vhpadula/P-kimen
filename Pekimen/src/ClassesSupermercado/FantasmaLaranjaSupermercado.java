package ClassesSupermercado;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.FantasmaLaranja;

public class FantasmaLaranjaSupermercado extends FantasmaLaranja {

	public FantasmaLaranjaSupermercado(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma,
			int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.up = "Supermercado/fantasmaLaranja.png";
		this.down = "Supermercado/fantasmaLaranja.png";
		this.left = "Supermercado/fantasmaLaranja.png";
		this.right = "Supermercado/fantasmaLaranja.png";
		this.setImage("Supermercado/fantasmaLaranja.png");
	}

}
