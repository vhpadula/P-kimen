package ClassesPersonagens;

import ClassesGerais.Controle;
import ClassesGerais.ID;

public abstract class FantasmaVermelho extends Fantasmas {

	public FantasmaVermelho(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma, int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
	}
	
	ChaseRed chase = new ChaseRed(super.controle, this);
	Scatter scatter = new Scatter (super.controle, this, 700, 0);
	MovimentacaoGeral geral = new MovimentacaoGeral(super.controle, this);

	@Override
	public void tick() {
		x += VxFantasma;
		y += VyFantasma;
		controle.xRedGhost = x;
		controle.yRedGhost = y;
		if (gaiola)
			geral.sairGaiola(this);
		chase.movimentar();
		geral.teleporte();
		geral.movimentar();
	}
}
