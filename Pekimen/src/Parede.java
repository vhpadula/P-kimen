import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Parede extends ObjetoJogo {
	Image textura;
	
	Parede (int x, int y) throws IOException{
		super( x,  y);
		textura = ImageIO.read(new File("src\\terra.png"));
		
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, 20*x, 20*y, 20, 20, null);
		
	}
	
	
	
}
