package ClassesPersonagens;

import java.util.Random;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesGerais.Jogo;
import ClassesGerais.ObjetoJogo;

public class MovimentacaoGeral implements MovimentacaoFantasma {
	
	Controle controle;
	Fantasmas fantasma;
	
	public MovimentacaoGeral(Controle controle, Fantasmas fantasma){
		this.controle = controle;
		this.fantasma = fantasma;
	}
	
	public void movimentar() {
		for (int i = 0; i < controle.objetos.size(); i++) {
			ObjetoJogo tempObject = controle.objetos.get(i);
			colisao(tempObject);
		}
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
	
	protected void teleporte() {
		fantasma.x = Jogo.teleporte(fantasma.x, 0, 846);
		fantasma.y = Jogo.teleporte(fantasma.y, 42, 680);
	}
	
	protected int setVInicial() {
		Random rand = new Random();
		int aleatorio = rand.nextInt();
		if (aleatorio % 2 == 1)
			return -fantasma.velocidade;
		else
			return fantasma.velocidade;
	}
	
	protected void sairGaiola(Fantasmas fantasma) {
		if (fantasma.getClass().toString().contains("Rosa")) {
			fantasma.VyFantasma = -1;
			if (fantasma.getY() == fantasma.yInicial - 63) {
				fantasma.gaiola = false;
				fantasma.VxFantasma = setVInicial();
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
				fantasma.VxFantasma = setVInicial();
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
				fantasma.VxFantasma = setVInicial();
				fantasma.VyFantasma = 0;
			}
		} else {
			fantasma.gaiola = false;
			fantasma.VxFantasma = setVInicial();
		}
	}
	
	void colisao(ObjetoJogo tempObject) {
		if (tempObject.getID() == ID.Parede) {
			if (fantasma.getBounds().intersects(tempObject.getBounds())) {
				if (!(tempObject.cruzamento == "U" && fantasma.VyFantasma < 0)) {
					fantasma.x -= fantasma.VxFantasma;
					fantasma.y -= fantasma.VyFantasma;

					if (fantasma.VxFantasma != 0) {
						fantasma.VxFantasma = 0;
						if (fantasma.vAnterior == "H" || fantasma.vAnterior == null) {
							fantasma.VyFantasma = 0;
						} else {
							fantasma.VyFantasma = fantasma.valorVAnterior;
							fantasma.vAnterior = "V";
						}
					} else {
						fantasma.VyFantasma = 0;
						if (fantasma.vAnterior == "V" || fantasma.vAnterior == null) {
							fantasma.VxFantasma = 0;
						} else {
							fantasma.VxFantasma = fantasma.valorVAnterior;
							fantasma.vAnterior = "H";
						}
					}
				}
			}
		}
	}
}
