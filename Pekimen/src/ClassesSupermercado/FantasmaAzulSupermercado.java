package ClassesSupermercado;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.FantasmaAzul;

public class FantasmaAzulSupermercado extends FantasmaAzul {

	public FantasmaAzulSupermercado(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma,
			int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.up = "Supermercado/fantasmaAzulMaskU.png";
		this.down = "Supermercado/fantasmaAzulMaskD.png";
		this.left = "Supermercado/fantasmaAzulMaskL.png";
		this.right = "Supermercado/fantasmaAzulMaskR.png";
		this.setImage("Supermercado/fantasmaAzulMaskR.png");
	}
}
