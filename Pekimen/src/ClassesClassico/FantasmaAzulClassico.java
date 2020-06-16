package ClassesClassico;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.FantasmaAzul;

public class FantasmaAzulClassico extends FantasmaAzul {

	public FantasmaAzulClassico(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma,
			int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.up = "Classic/fantasmaAzulU.png";
		this.down = "Classic/fantasmaAzulD.png";
		this.left = "Classic/fantasmaAzulL.png";
		this.right = "Classic/fantasmaAzulR.png";
		this.setImage("Classic/fantasmaAzulR.png");
	}

}
