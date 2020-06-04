
public class FantasmaVermelho extends Fantasmas {

	FantasmaVermelho(int x, int y, String imagePath, ID id, Mapa mapa, Controle controle) {
		super(x, y, imagePath, id, mapa, controle);
	}

	@Override
	public void tick() {
		for (int i = 0; i < controle.objetos.size(); i++) {
			ObjetoJogo temp = controle.objetos.get(i);
			if (temp.getID() == ID.Pacman) {
				if (temp.getX() < this.getX()) {
					this.setVx(-1);
					this.setVy(0);
				} else if (temp.getX() > this.getX()) {
					this.setVx(1);
					this.setVy(0);
				} else if (temp.getY() < this.getY()) {
					this.setVy(-1);
					this.setVx(0);
				} else if (temp.getY() > this.getY()) {
					this.setVy(1);
					this.setVx(0);
				}
			}
			else if (temp.getID() == ID.Parede) {
				if (temp.getX() == this.getX() + 30) {
					setVx(-1);
					setVy(0);
				}
			}
		}
		x += Vx;
		y += Vy;
		super.colisao();
		super.teleporte();
	}
}
