package ClassesPersonagens;

import java.awt.Graphics;
import java.awt.Rectangle;

import ClassesGerais.Controle;
import ClassesGerais.ID;

public class DecoratorSpeedUp extends ObjetoJogoDecorator {
	
	public DecoratorSpeedUp(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
	}

	public void setVel(PacmanBasico pacman) {
		pacman.setVel(3);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}
}
