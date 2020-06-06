package ClassesSupermercado;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.FantasmaLaranja;

public class FantasmaLaranjaSupermercado extends FantasmaLaranja {

	public FantasmaLaranjaSupermercado(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma,
			int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.imagePath = "Supermercado/fantasmaLaranja.png";
		this.ajustaTextura();
	}

}
