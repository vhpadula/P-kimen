import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Parede extends ObjetoJogo {
	Image textura;

	Parede(int x, int y) throws IOException {
		super(x, y);
		String imagePath;
		String sistemaOperacional = System.getProperty("os.name");
		if (sistemaOperacional.contains("Windows")) {
			imagePath = "src/texturas/terra.png";
		} else {
			imagePath = "texturas/terra.png";
		}
		textura = ImageIO.read(new File(imagePath));
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, 20 * x, 20 * y, 20, 20, null);

	}

}
