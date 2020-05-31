import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Fantasmas extends ObjetoJogo {

	Fantasmas(int x, int y, String imagePath, ID id, Mapa mapa, Controle controle) {
		super(x, y, imagePath, id, mapa, controle);
	}

	@Override
	public abstract void tick();

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, x, y, 20, 20, null);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 20, 20);
	}

}
