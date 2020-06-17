package ClassesSelva;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.PacmanBasico;


public class PacmanSelva extends PacmanBasico{

	public PacmanSelva(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
		this.up = "Classic/pacman_up.png";
		this.down = "Classic/pacman_down.png";
		this.left = "Classic/pacman_left.png";
		this.right = "Classic/pacman_right.png";
		this.setImage("Classic/pacman_right.png");
	}

}
