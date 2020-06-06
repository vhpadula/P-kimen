package ClassesPersonagens;
import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesInterface.HUD;
import ClassesTabuleiro.Mapa;

public abstract class FantasmaLaranja extends Fantasmas {

	public FantasmaLaranja(int x, int y,  ID id,  Controle controle, String cruzamento,
			int VxFantasma, int VyFantasma) {
		super(x, y,  id, controle, cruzamento, VxFantasma, VyFantasma);
	}

	@Override
	public void tick() {
		x += VxFantasma;
		y += VyFantasma;
		if(gaiola && HUD.pontos >= pontosIniciais + 600)
			super.sairGaiola(this);
		else
			movimentacaoGaiola();
		super.movimentacao();
		super.teleporte();
	}
}
