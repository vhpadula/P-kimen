package ClassesSelva;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.FantasmaRosa;

public class FantasmaRosaSelva extends FantasmaRosa {

	public FantasmaRosaSelva(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma,
			int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.up = "Selva/fantasmaRosaSaiaU.png";
		this.down = "Selva/fantasmaRosaSaiaD.png";
		this.left = "Selva/fantasmaRosaSaiaL.png";
		this.right = "Selva/fantasmaRosaSaiaR.png";
		this.setImage("Selva/fantasmaRosaSaiaR.png");
	}
}
