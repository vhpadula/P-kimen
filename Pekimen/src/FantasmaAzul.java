
public class FantasmaAzul extends Fantasmas {

	FantasmaAzul(int x, int y, String imagePath, ID id, Mapa mapa, Controle controle) {
		super(x, y, imagePath, id, mapa, controle);
	}

	@Override
	public void tick() {
		//setVx(1);
		//x += Vx;
		super.colisao();
		super.teleporte();
	}

}
