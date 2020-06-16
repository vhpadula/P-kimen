package ClassesSupermercado;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.FantasmaRosa;

public class FantasmaRosaSupermercado extends FantasmaRosa {

	public FantasmaRosaSupermercado(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma,
			int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.up = "Supermercado/fantasmaRosa.png";
		this.down = "Supermercado/fantasmaRosa.png";
		this.left = "Supermercado/fantasmaRosa.png";
		this.right = "Supermercado/fantasmaRosa.png";
		this.setImage("Supermercado/fantasmaRosa.png");
	}

}
