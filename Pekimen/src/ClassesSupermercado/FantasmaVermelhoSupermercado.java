package ClassesSupermercado;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.FantasmaVermelho;

public class FantasmaVermelhoSupermercado extends FantasmaVermelho {

	public FantasmaVermelhoSupermercado(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma,
			int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.imagePath = "Supermercado/fantasmaVermelho.png";
		this.ajustaTextura();
	}

}
