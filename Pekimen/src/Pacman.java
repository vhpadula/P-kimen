import java.awt.Graphics;
import java.awt.Rectangle;

public class Pacman extends ObjetoJogo {

	Pacman(int x, int y, String imagePath, ID id, Mapa mapa, Controle controle) {
		super(x, y, imagePath, id, mapa, controle);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 20, 15);
	}

	@Override
	public void tick() {

		if (x > 856)
			x = 0;

		if (x < 0)
			x = 856;

		if (y > 680)
			y = 42;

		if (y < 42)
			y = 680;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, x, y, 20, 15, null);
	}
	
	private void colisao() {
		for(int i = 0; i < controle.objetos.size(); i++) {
			ObjetoJogo tempObject = controle.objetos.get(i);
			if (tempObject.getID() == ID.Parede) {
				if(getBounds().intersects(tempObject.getBounds())) {
					
				}
			}
		}
	}

}
