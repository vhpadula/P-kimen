package Niveis;

import ClassesGerais.Controle;

public class NivelUm extends Nivel {

	public NivelUm(Controle ctrl) {
		super(ctrl);
		vFantasma = 1;
		vPacman = 2;
		mapa = "maps/classic.txt";
	}
}
