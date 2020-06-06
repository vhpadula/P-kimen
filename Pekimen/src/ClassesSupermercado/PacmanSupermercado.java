package ClassesSupermercado;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.Pacman;

public class PacmanSupermercado extends Pacman {

	public PacmanSupermercado(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
		this.imagePath= "Supermercado/pacman_right.png";
		this.up = "Supermercado/pacman_up.png";
		this.down = "Supermercado/pacman_down.png";
		this.left = "Supermercado/pacman_left.png";
		this.right= "Supermercado/pacman_right.png";
		this.ajustaTextura();
	}

}
