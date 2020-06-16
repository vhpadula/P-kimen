package ClassesSelva;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.FantasmaLaranja;

public class FantasmaLaranjaSelva extends FantasmaLaranja{

	public FantasmaLaranjaSelva(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma,
			int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.up = "Classic/fantasmaLaranjaU.png";
		this.down = "Classic/fantasmaLaranjaD.png";
		this.left = "Classic/fantasmaLaranjaL.png";
		this.right = "Classic/fantasmaLaranjaR.png";
		this.setImage("Classic/fantasmaLaranjaR.png");
	}

}
