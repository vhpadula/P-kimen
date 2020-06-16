package ClassesPersonagens;

import ClassesGerais.Controle;
import ClassesGerais.ID;

public abstract class FantasmaRosa extends Fantasmas {

	public FantasmaRosa(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma, int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
	}

	ChasePink chase = new ChasePink(super.controle, this);
	Scatter scatter = new Scatter(super.controle, this, 0, 0);
	MovimentacaoGeral geral = new MovimentacaoGeral(super.controle, this);

	@Override
	public void tick() {
		x += VxFantasma;
		y += VyFantasma;
		if (gaiola)
			geral.sairGaiola(this);
		chase.movimentar();
		geral.teleporte();
		geral.movimentar();
		SetTexture(VyFantasma, VxFantasma);
	}
}
