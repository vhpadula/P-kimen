import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;

public class Parede extends ObjetoJogo {

	Parede(int x, int y, String imagePath, ID id, Mapa mapa, Controle controle) throws IOException {
		super(x, y, imagePath, id, mapa, controle);

	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(25 * x, 16 * y, 25, 16);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, 25 * x, 16 * y, 25, 16, null);

	}

}
