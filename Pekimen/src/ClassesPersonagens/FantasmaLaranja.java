package ClassesPersonagens;
import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesTabuleiro.Mapa;

public abstract class FantasmaLaranja extends Fantasmas {

	public FantasmaLaranja(int x, int y,  ID id,  Controle controle, String cruzamento,
			int VxFantasma, int VyFantasma) {
		super(x, y,  id, controle, cruzamento, VxFantasma, VyFantasma);
	}

	@Override
	public void tick() {
		super.colisao(this);
		super.teleporte();
	}
}
