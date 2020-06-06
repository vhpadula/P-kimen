package ClassesClassico;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.Pacman;

public class PacmanClassico extends Pacman {
	
	public PacmanClassico(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
		this.imagePath= "Classic/pacman_right.png";
		this.up = "Classic/pacman_up.png";
		this.down = "Classic/pacman_down.png";
		this.left = "Classic/pacman_left.png";
		this.right= "Classic/pacman_right.png";
		this.ajustaTextura();
	}

}
