import java.awt.Graphics;

import java.io.IOException;


public class Parede extends ObjetoJogo {
	

	Parede(int x, int y, String imagePath, ID id) throws IOException {
		super(x, y,imagePath, id);
		
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, 30 * x, 21 * y, 30, 21, null);

	}

}
