package ClassesSelva;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.FantasmaVermelho;

public class FantasmaVermelhoSelva extends FantasmaVermelho {

	public FantasmaVermelhoSelva(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma,
			int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.imagePath = "Classic/fantasmaVermelho.png";
		this.ajustaTextura();
	}

}
