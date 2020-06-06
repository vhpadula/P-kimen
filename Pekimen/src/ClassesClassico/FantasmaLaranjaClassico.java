package ClassesClassico;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.FantasmaRosa;

public class FantasmaLaranjaClassico extends FantasmaRosa {

	public FantasmaLaranjaClassico(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma,
			int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.imagePath = "Classic/fantasmaLaranja.png";
		this.ajustaTextura();
	}

}
