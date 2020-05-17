import java.awt.Graphics;

public class Pastilha extends ObjetoJogo {

	Pastilha(int x, int y, String imagePath, ID id) {
		super(x, y, imagePath, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, 20*x + 10, 20*y +10, 3, 3, null);
		
	}
	
}
