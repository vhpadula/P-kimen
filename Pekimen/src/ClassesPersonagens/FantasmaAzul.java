package ClassesPersonagens;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesInterface.HUD;

public abstract class FantasmaAzul extends Fantasmas {
	
	public FantasmaAzul(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma, int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
	}
	
	MovimentacaoVermelho movimentacao = new MovimentacaoVermelho(super.controle, this);
	MovimentacaoGeral geral = new MovimentacaoGeral(super.controle, this);

	@Override
	public void tick() {
		x += VxFantasma;
		y += VyFantasma;
		if (gaiola && HUD.pontos >= pontosIniciais + 300)
			geral.sairGaiola(this);
		else
			geral.movimentacaoGaiola();
		movimentacao.movimentar(); // Falta implementar a movimentação do azul
		super.teleporte();
	}
}
