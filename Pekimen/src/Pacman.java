import java.awt.Color;
import java.awt.Graphics;

public class Pacman extends ObjetoJogo {

	Pacman(int x, int y,String imagePath, ID id,Mapa mapa) {
		super(x, y,imagePath, id,mapa);
	}

	@Override
	public void tick() {
		
		if (mapa.map[x/30+Vx][y/21] != '|')
			x+=Vx;
		
		
		if (x>856) 
			x=0;
		
		if (x<0) 
			x=856;
		
		if (mapa.map[x/30][y/21+Vy] != '|')
			y+=Vy;
		
		if (y>680) 
			y=42;
		
		if (y<42) 
			y=680;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, x, y ,20, 15, null);
	}

}
