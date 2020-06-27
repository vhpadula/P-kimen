package ClassesSupermercado;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.FantasmaLaranja;

public class FantasmaLaranjaSupermercado extends FantasmaLaranja {

	public FantasmaLaranjaSupermercado(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma,
			int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.up = "Supermercado/fantasmaLaranjaMaskU.png";
		this.down = "Supermercado/fantasmaLaranjaMaskD.png";
		this.left = "Supermercado/fantasmaLaranjaMaskL.png";
		this.right = "Supermercado/fantasmaLaranjaMaskR.png";
		this.setImage("Supermercado/fantasmaLaranjaMaskR.png");
	}
}
