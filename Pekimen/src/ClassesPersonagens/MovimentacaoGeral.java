package ClassesPersonagens;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesGerais.ObjetoJogo;

public class MovimentacaoGeral {
	
	Controle controle;
	Fantasmas fantasma;
	
	public MovimentacaoGeral(Controle controle, Fantasmas fantasma){
		this.controle = controle;
		this.fantasma = fantasma;
	}
	
	protected void movimentacaoGaiola() {
		for (int i = 0; i < controle.objetos.size(); i++) {
			ObjetoJogo tempObject = controle.objetos.get(i);
			if (tempObject.getID() == ID.Parede) {
				if (fantasma.getBounds().intersects(tempObject.getBounds())) {
					fantasma.x -= fantasma.VxFantasma;
					fantasma.y -= fantasma.VyFantasma;

					fantasma.VyFantasma *= -1;
				}
			}
		}
	}
	
	protected void sairGaiola(Fantasmas fantasma) {
		if (fantasma.getClass().toString().contains("Rosa")) {
			fantasma.VyFantasma = -1;
			if (fantasma.getY() == fantasma.yInicial - 63) {
				fantasma.gaiola = false;
				fantasma.VxFantasma = fantasma.setVInicial();
				fantasma.VyFantasma = 0;
			}
		} else if (fantasma.getClass().toString().contains("Azul")) {
			fantasma.VxFantasma = 1;
			fantasma.VyFantasma = 0;
			if (fantasma.getX() == fantasma.xInicial + 30) {
				fantasma.VxFantasma = 0;
				fantasma.VyFantasma = -1;
			}
			if (fantasma.getY() == fantasma.yInicial - 63) {
				fantasma.gaiola = false;
				fantasma.VxFantasma = fantasma.setVInicial();
				fantasma.VyFantasma = 0;
			}
		} else if (fantasma.getClass().toString().contains("Laranja")) {
			fantasma.VxFantasma = -1;
			fantasma.VyFantasma = 0;
			if (fantasma.getX() == fantasma.xInicial - 30) {
				fantasma.VxFantasma = 0;
				fantasma.VyFantasma = -1;
			}
			if (fantasma.getY() == fantasma.yInicial - 63) {
				fantasma.gaiola = false;
				fantasma.VxFantasma = fantasma.setVInicial();
				fantasma.VyFantasma = 0;
			}
		} else {
			fantasma.gaiola = false;
			fantasma.VxFantasma = fantasma.setVInicial();
		}
	}
}
