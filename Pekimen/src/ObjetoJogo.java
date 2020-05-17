import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class ObjetoJogo {
	protected int x, Vx;
	protected int y, Vy;
	protected ID id;
	Mapa mapa;
	protected BufferedImage textura;

	ObjetoJogo(int x, int y, String imagePath, ID id, Mapa mapa) {
		this.x = x;
		this.y = y;
		this.id=id;
		this.mapa= mapa;
		imagePath = SetPath.setPath(imagePath);
		try {
			this.textura= ImageIO.read(new File(imagePath));
		}catch(IOException e) {
			System.out.println(e);
		}
		/*String sistemaOperacional = System.getProperty("os.name");
		if (sistemaOperacional.contains("Windows")) {
			imagePath = "src/"+ imagePath;
		}
		try {
			this.textura= ImageIO.read(new File(imagePath));
		}catch(IOException e) {
			System.out.println(e);
		}*/
		
	}

	public abstract void tick();

	public abstract void render(Graphics g);

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
}
