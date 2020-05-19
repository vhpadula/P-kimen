import java.awt.Graphics;
import java.awt.Rectangle;

public class Pastilha extends ObjetoJogo {

	Pastilha(int x, int y, String imagePath, ID id, Mapa mapa, Controle controle) {
		super(x, y, imagePath, id, mapa, controle);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(25 * x + 12, 16 * y + 8, 3, 3);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, 25 * x + 12, 16 * y + 8, 3, 3, null);

	}

}
