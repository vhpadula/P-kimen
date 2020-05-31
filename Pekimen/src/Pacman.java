import java.awt.Graphics;
import java.awt.Rectangle;

public class Pacman extends ObjetoJogo {

	Controle controle;
	
	Pacman(int x, int y, String imagePath, ID id, Mapa mapa, Controle controle) {
		super(x, y, imagePath, id, mapa, controle);
		this.controle = controle;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 30, 20);
	}

	@Override
	public void tick() {
		x += Vx;
		y += Vy;
		//abrange os casos de teleporte
		x = Jogo.teleporte(x, 0, 846);
		y = Jogo.teleporte(y, 42, 680); //teria que mudar o valor do teleporte tbm caso implemente a tela menor mesmo
		colisao();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, x, y, 30, 20, null);
	}

	private void colisao() {
		for(int i = 0; i < controle.objetos.size(); i++) {
			ObjetoJogo tempObject = controle.objetos.get(i);
			if (tempObject.getID() == ID.Parede) {
				if(getBounds().intersects(tempObject.getBounds())) {
					x -= Vx;
					y -= Vy;
				}
			}
			if(tempObject.getID() == ID.Pastilha) {
				if(getBounds().intersects(tempObject.getBounds())) {
					controle.objetos.remove(i);
					HUD.setPontos(10);
				}
			}
		}
	}
}
