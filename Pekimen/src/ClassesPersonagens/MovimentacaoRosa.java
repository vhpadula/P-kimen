package ClassesPersonagens;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesGerais.ObjetoJogo;

public class MovimentacaoRosa implements MovimentacaoFantasma {
	
	Controle controle;
	Fantasmas fantasma;
	
	public MovimentacaoRosa(Controle controle, Fantasmas fantasma) {
		this.controle = controle;
		this.fantasma = fantasma;
	}
	
	MovimentacaoGeral geral = new MovimentacaoGeral(controle, fantasma);
	
	public void movimentar() {
		for (int i = 0; i < controle.objetos.size(); i++) {
			ObjetoJogo tempObject = controle.objetos.get(i);
			cruzamentoRosa(tempObject);
			fantasma.colisao(tempObject);
		}
	}

	double getTargetRosa(int x, int y) {
		double targetX = controle.xPacman, targetY = controle.yPacman;
		if (controle.direcaoPacman == 'R') {
			targetX += 120;
		} else if (controle.direcaoPacman == 'L') {
			targetX -= 120;
		} else if (controle.direcaoPacman == 'D') {
			targetY += 84;
		} else if (controle.direcaoPacman == 'U') {
			targetX -= 120;
			targetY -= 84;
		}

		double distancia = Math.sqrt(Math.pow(targetX - x, 2) + Math.pow(targetY - y, 2));
		return distancia;
	}

	public char rosaChaseMode(ObjetoJogo tempObject) {
		double distanciaD = 10000000;
		double distanciaU = 10000000;
		double distanciaL = 10000000;
		double distanciaR = 10000000;
		char direcao = 'N';

		if (tempObject.cruzamento.toString().contains("D") && !(fantasma.VyFantasma < 0))
			distanciaD = getTargetRosa(fantasma.x, fantasma.y + 3);
		if (tempObject.cruzamento.toString().contains("U") && !(fantasma.VyFantasma > 0))
			distanciaU = getTargetRosa(fantasma.x, fantasma.y - 3);
		if (tempObject.cruzamento.toString().contains("L") && !(fantasma.VxFantasma > 0))
			distanciaL = getTargetRosa(fantasma.x - 3, fantasma.y);
		if (tempObject.cruzamento.toString().contains("R") && !(fantasma.VxFantasma < 0))
			distanciaR = getTargetRosa(fantasma.x + 3, fantasma.y);

		if (distanciaD < distanciaU && distanciaD < distanciaL && distanciaD < distanciaR && !(fantasma.VyFantasma > 0))
			direcao = 'D';
		else if (distanciaU < distanciaD && distanciaU < distanciaL && distanciaU < distanciaR && !(fantasma.VyFantasma < 0))
			direcao = 'U';
		else if (distanciaL < distanciaU && distanciaL < distanciaD && distanciaL < distanciaR && !(fantasma.VxFantasma > 0))
			direcao = 'L';
		else if (distanciaR < distanciaD && distanciaR < distanciaU && distanciaR < distanciaL && !(fantasma.VxFantasma < 0))
			direcao = 'R';

		return direcao;
	}

	public void cruzamentoRosa(ObjetoJogo tempObject) {
		if (tempObject.getID() == ID.Cruzamento) {
			double xCruzamento = tempObject.getBounds().getCenterX();
			double yCruzamento = tempObject.getBounds().getCenterY();
			double xFantasma = fantasma.getBounds().getCenterX();
			double yFantasma = fantasma.getBounds().getCenterY();
			if ((xFantasma == xCruzamento - 1.5 && yFantasma == yCruzamento - 1.5)
					|| (xFantasma == xCruzamento - 1.5 && yFantasma == yCruzamento - 0.5)) {
				char direcao = rosaChaseMode(tempObject);
				if (direcao == 'U') {
					fantasma.VxFantasma = 0;
					fantasma.VyFantasma = -2;
					fantasma.vAnterior = "V";
				} else if (direcao == 'D') {
					fantasma.VxFantasma = 0;
					fantasma.VyFantasma = 2;
					fantasma.vAnterior = "V";
				} else if (direcao == 'R') {
					fantasma.VxFantasma = 2;
					fantasma.VyFantasma = 0;
					fantasma.vAnterior = "H";
				} else if (direcao == 'L') {
					fantasma.VxFantasma = -2;
					fantasma.VyFantasma = 0;
					fantasma.vAnterior = "H";
				}
			}
		}
	}
}
