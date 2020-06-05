
public class FantasmaAzul extends Fantasmas {

	FantasmaAzul(int x, int y, String imagePath, ID id, Mapa mapa, Controle controle, String cruzamento, int VxFantasma,
			int VyFantasma) {
		super(x, y, imagePath, id, mapa, controle, cruzamento, VxFantasma, VyFantasma);
	}

	@Override
	public void tick() {
		// setVx(1);
		// x += Vx;
		super.colisao(this);
		super.teleporte();
	}

}
