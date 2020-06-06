package ClassesClassico;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.FantasmaRosa;

public class FantasmaRosaClassico extends FantasmaRosa {

	public FantasmaRosaClassico(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma,
			int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.imagePath = "Classic/fantasmaRosa.png";
		this.ajustaTextura();
	}

}
