package ClassesSelva;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesPersonagens.PacmanBasico;

public class PacmanSelva extends PacmanBasico {

	public PacmanSelva(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
		this.up = "Selva/pacmanSaiaU.png";
		this.down = "Selva/pacmanSaiaD.png";
		this.left = "Selva/pacmanSaiaL.png";
		this.right = "Selva/pacmanSaiaR.png";
		this.setImage("Selva/pacmanSaiaR.png");
	}
}
