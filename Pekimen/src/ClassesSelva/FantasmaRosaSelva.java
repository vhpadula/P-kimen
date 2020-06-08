package ClassesSelva;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.FantasmaRosa;

public class FantasmaRosaSelva extends FantasmaRosa {

	public FantasmaRosaSelva(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma,
			int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.imagePath = "Classic/fantasmaRosa.png";
		this.ajustaTextura();
	}

}
