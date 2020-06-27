package Niveis;

import ClassesGerais.Controle;

public class NivelDoisAQuatro extends Nivel {

	public NivelDoisAQuatro(Controle ctrl) {
		super(ctrl);
		vFantasma = 2;
		vPacman = 3;
		mapa = "maps/classic3.txt";
	}
}
