package ClassesPersonagens;
import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesTabuleiro.Mapa;

public class FantasmaVermelho extends Fantasmas {

	public FantasmaVermelho(int x, int y, String imagePath, ID id, Mapa mapa, Controle controle, String cruzamento,
			int VxFantasma, int VyFantasma) {
		super(x, y, imagePath, id, mapa, controle, cruzamento, VxFantasma, VyFantasma);
	}

	@Override
	public void tick() {
		x += VxFantasma;
		y += VyFantasma;
		super.movimentacao();
		super.teleporte();
	}
}
