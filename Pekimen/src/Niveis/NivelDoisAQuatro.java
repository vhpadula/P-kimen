package Niveis;

import ClassesGerais.Controle;

public class NivelDoisAQuatro extends Nivel {

	public NivelDoisAQuatro(Controle ctrl) {
		super(ctrl);
		vFantasma = 2;
		vPacman = 2;
		mapa = "maps/classic2.txt";
	}
}
