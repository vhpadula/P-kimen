import java.awt.Graphics;
import java.awt.Rectangle;

public class Cruzamento extends ObjetoJogo {
	Cruzamento(int x, int y, String imagePath, ID id, Mapa mapa, Controle controle, String cruzamento){
		super(x, y, imagePath, id, mapa, controle, cruzamento);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(30 * x + 15, 21 * y + 10, 3, 3);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, 30 * x + 15, 21 * y + 10, 3, 3, null);

	}

}
