package ClassesSupermercado;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.FantasmaRosa;

public class FantasmaRosaSupermercado extends FantasmaRosa {

	public FantasmaRosaSupermercado(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma,
			int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.up = "Supermercado/fantasmaRosaMaskU.png";
		this.down = "Supermercado/fantasmaRosaMaskD.png";
		this.left = "Supermercado/fantasmaRosaMaskL.png";
		this.right = "Supermercado/fantasmaRosaMaskR.png";
		this.setImage("Supermercado/fantasmaRosaMaskR.png");
	}
}
