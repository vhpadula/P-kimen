package ClassesPersonagens;

import ClassesGerais.Controle;
import ClassesGerais.ID;

public abstract class FantasmaVermelho extends Fantasmas {

	public FantasmaVermelho(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma, int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
	}

	@Override
	public void tick() {
		x += VxFantasma;
		y += VyFantasma;
		if (gaiola)
			sairGaiola(this);
		super.movimentacao();
		super.teleporte();
	}
}
