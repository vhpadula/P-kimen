import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Fantasmas extends ObjetoJogo {

	Fantasmas(int x, int y, String imagePath, ID id, Mapa mapa, Controle controle, String cruzamento) {
		super(x, y, imagePath, id, mapa, controle, cruzamento);
	}

	@Override
	public abstract void tick();

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, x, y, 20, 20, null);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 20, 20);
	}
	
	protected void colisao() {
		for(int i = 0; i < controle.objetos.size(); i++) {
			ObjetoJogo tempObject = controle.objetos.get(i);
			if (tempObject.getID() == ID.Parede) {
				if(getBounds().intersects(tempObject.getBounds())) {
					x -= Vx;
					y -= Vy;
				}
			}
		}
	}
	
	protected void teleporte() {
		x = Jogo.teleporte(x, 0, 846);
		y = Jogo.teleporte(y, 42, 680);
	}

}
