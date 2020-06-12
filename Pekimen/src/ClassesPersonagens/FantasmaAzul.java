package ClassesPersonagens;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesInterface.HUD;

public abstract class FantasmaAzul extends Fantasmas {
	
	public FantasmaAzul(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma, int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
	}
	
	ChaseBlue chase = new ChaseBlue(super.controle, this);
	Scatter scatter = new Scatter(super.controle, this, 700, 700);
	MovimentacaoGeral geral = new MovimentacaoGeral(super.controle, this);

	@Override
	public void tick() {
		x += VxFantasma;
		y += VyFantasma;
		if (gaiola && HUD.pontos >= pontosIniciais + 300)
			geral.sairGaiola(this);
		else
			geral.movimentacaoGaiola();
		chase.movimentar(); 
		geral.teleporte();
		geral.movimentar();
	}
}
