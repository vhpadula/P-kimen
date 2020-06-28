package ClassesSelva;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.FantasmaLaranja;

public class FantasmaLaranjaSelva extends FantasmaLaranja{

	public FantasmaLaranjaSelva(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma,
			int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.up = "Selva/fantasmaLaranjaSaiaU.png";
		this.down = "Selva/fantasmaLaranjaSaiaD.png";
		this.left = "Selva/fantasmaLaranjaSaiaL.png";
		this.right = "Selva/fantasmaLaranjaSaiaR.png";
		this.setImage("Selva/fantasmaLaranjaSaiaR.png");
	}
}
