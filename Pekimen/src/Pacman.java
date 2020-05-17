import java.awt.Color;
import java.awt.Graphics;

public class Pacman extends ObjetoJogo {

	Pacman(int x, int y,String imagePath, ID id) {
		super(x, y,imagePath, id);
	}

	@Override
	public void tick() {
		x+=Vx;
		y+=Vy;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, 7, 7);
	}

}
