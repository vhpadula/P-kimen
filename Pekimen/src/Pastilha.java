import java.awt.Graphics;

public class Pastilha extends ObjetoJogo {

	Pastilha(int x, int y, String imagePath, ID id,Mapa mapa) {
		super(x, y, imagePath, id, mapa);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, 30*x + 15, 21*y + 10, 3, 3, null);
		
	}
	
}
