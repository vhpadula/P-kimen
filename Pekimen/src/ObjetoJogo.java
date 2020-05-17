import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class ObjetoJogo {
	protected int x, Vx;
	protected int y, Vy;
	protected ID id;
	Mapa mapa;
	Controle controle;
	protected BufferedImage textura;

	ObjetoJogo(int x, int y, String imagePath, ID id, Mapa mapa, Controle controle) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.mapa = mapa;
		this.controle = controle;
		imagePath = SetPath.setPath(imagePath);
		try {
			this.textura = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public abstract Rectangle getBounds();

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setVx(int Vx) {
		this.Vx = Vx;
	}

	public void setVy(int Vy) {
		this.Vy = Vy;
	}
	
	public ID getID() {
		return this.id;
	}
}
