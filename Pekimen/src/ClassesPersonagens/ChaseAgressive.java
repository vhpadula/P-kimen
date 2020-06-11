package ClassesPersonagens;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesGerais.ObjetoJogo;

public class ChaseAgressive implements MovimentacaoFantasma {
	
	Controle controle;
	Fantasmas fantasma;
	
	public ChaseAgressive(Controle controle, Fantasmas fantasma) {
		this.controle = controle;
		this.fantasma = fantasma;
	}
	
	public void movimentar() {
		for (int i = 0; i < controle.objetos.size(); i++) {
			ObjetoJogo tempObject = controle.objetos.get(i);
			cruzamento(tempObject);
		}
	}

	private double getTargetVermelho(int x, int y) {
		double distancia = Math.sqrt(Math.pow(controle.xPacman - x, 2) + Math.pow(controle.yPacman - y, 2));
		return distancia;
	}

	char chaseMode(ObjetoJogo tempObject) {
		double distanciaD = 10000000;
		double distanciaU = 10000000;
		double distanciaL = 10000000;
		double distanciaR = 10000000;

		if (tempObject.cruzamento.toString().contains("D") && !(fantasma.VyFantasma < 0))
			distanciaD = getTargetVermelho(fantasma.x, fantasma.y + 1);
		if (tempObject.cruzamento.toString().contains("U") && !(fantasma.VyFantasma > 0))
			distanciaU = getTargetVermelho(fantasma.x, fantasma.y - 1);
		if (tempObject.cruzamento.toString().contains("L") && !(fantasma.VxFantasma > 0))
			distanciaL = getTargetVermelho(fantasma.x - 1, fantasma.y);
		if (tempObject.cruzamento.toString().contains("R") && !(fantasma.VxFantasma < 0))
			distanciaR = getTargetVermelho(fantasma.x + 1, fantasma.y);

		if (distanciaD < distanciaU && distanciaD < distanciaL && distanciaD < distanciaR)
			return 'D';
		else if (distanciaU < distanciaD && distanciaU < distanciaL && distanciaU < distanciaR)
			return 'U';
		else if (distanciaL < distanciaU && distanciaL < distanciaD && distanciaL < distanciaR)
			return 'L';
		else
			return 'R';

	}

	protected void cruzamento(ObjetoJogo tempObject) {
		if (tempObject.getID() == ID.Cruzamento) {
			double xCruzamento = tempObject.getBounds().getCenterX();
			double yCruzamento = tempObject.getBounds().getCenterY();
			double xFantasma = fantasma.getBounds().getCenterX();
			double yFantasma = fantasma.getBounds().getCenterY();
			if ((xFantasma == xCruzamento - 1.5 && yFantasma == yCruzamento - 1.5)
					|| (xFantasma == xCruzamento - 1.5 && yFantasma == yCruzamento - 0.5)) {
				char direcao = chaseMode(tempObject);
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
