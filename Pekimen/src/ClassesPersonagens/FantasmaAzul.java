package ClassesPersonagens;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesInterface.HUD;

public abstract class FantasmaAzul extends Fantasmas {

	public FantasmaAzul(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma, int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
	}

	@Override
	public void tick() {
		x += VxFantasma;
		y += VyFantasma;
		if (gaiola && HUD.pontos >= pontosIniciais + 300)
			super.sairGaiola(this);
		else
			movimentacaoGaiola();
		super.movimentacaoVermelho(); // Falta implementar a movimentação do azul
		super.teleporte();
	}

}
