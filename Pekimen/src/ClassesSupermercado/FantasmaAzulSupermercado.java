package ClassesSupermercado;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.FantasmaAzul;

public class FantasmaAzulSupermercado extends FantasmaAzul {

	public FantasmaAzulSupermercado(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma,
			int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.imagePath = "Supermercado/fantasmaAzul.png";
		this.ajustaTextura();
	}

}
