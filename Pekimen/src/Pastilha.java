import java.awt.Graphics;
import java.awt.Rectangle;

public class Pastilha extends ObjetoJogo {

	Pastilha(int x, int y, String imagePath, ID id, Mapa mapa, Controle controle) {
		super(x, y, imagePath, id, mapa, controle);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 3, 3);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, 30 * x + 15, 21 * y + 10, 3, 3, null);

	}

}
