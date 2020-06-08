package ClassesSelva;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.FantasmaAzul;

public class FantasmaAzulSelva extends FantasmaAzul {

	public FantasmaAzulSelva(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma,
			int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.imagePath = "Classic/fantasmaAzul.png";
		this.ajustaTextura();
	}

}
