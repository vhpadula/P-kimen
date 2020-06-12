package ClassesPersonagens;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesGerais.ObjetoJogo;

public class ChaseOrange implements MovimentacaoFantasma {

    Controle controle;
    Fantasmas fantasma;

    public ChaseOrange(Controle controle, Fantasmas fantasma) {
        this.controle = controle;
        this.fantasma = fantasma;
    }

    public void movimentar() {
        for (int i = 0; i < controle.objetos.size(); i++) {
            ObjetoJogo tempObject = controle.objetos.get(i);
            cruzamento(tempObject);
        }
    }

    private double getTargetVermelho(int x, int y, double targetX, double targetY) {
        double distancia = Math.sqrt(Math.pow(targetX - x, 2) + Math.pow(targetY - y, 2));
        return distancia;
    }

    char chaseMode(ObjetoJogo tempObject) {
        double distanciaU = 10000003;
		double distanciaL = 10000002;
		double distanciaD = 10000001;
		double distanciaR = 10000000;

        double distanciaPacman = getTargetVermelho(fantasma.x, fantasma.y, controle.xPacman, controle.yPacman);

        if (distanciaPacman >= 200) {
            if (tempObject.cruzamento.toString().contains("D") && !(fantasma.VyFantasma < 0))
                distanciaD = getTargetVermelho(fantasma.x, fantasma.y + 1, controle.xPacman, controle.yPacman);
            if (tempObject.cruzamento.toString().contains("U") && !(fantasma.VyFantasma > 0))
                distanciaU = getTargetVermelho(fantasma.x, fantasma.y - 1, controle.xPacman, controle.yPacman);
            if (tempObject.cruzamento.toString().contains("L") && !(fantasma.VxFantasma > 0))
                distanciaL = getTargetVermelho(fantasma.x - 1, fantasma.y, controle.xPacman, controle.yPacman);
            if (tempObject.cruzamento.toString().contains("R") && !(fantasma.VxFantasma < 0))
                distanciaR = getTargetVermelho(fantasma.x + 1, fantasma.y, controle.xPacman, controle.yPacman);
        } else {
            if (tempObject.cruzamento.toString().contains("D") && !(fantasma.VyFantasma < 0))
                distanciaD = getTargetVermelho(fantasma.x, fantasma.y + 1, 0, 700);
            if (tempObject.cruzamento.toString().contains("U") && !(fantasma.VyFantasma > 0))
                distanciaU = getTargetVermelho(fantasma.x, fantasma.y - 1, 0, 700);
            if (tempObject.cruzamento.toString().contains("L") && !(fantasma.VxFantasma > 0))
                distanciaL = getTargetVermelho(fantasma.x - 1, fantasma.y, 0, 700);
            if (tempObject.cruzamento.toString().contains("R") && !(fantasma.VxFantasma < 0))
                distanciaR = getTargetVermelho(fantasma.x + 1, fantasma.y, 0, 700);
        }

        if (distanciaU <= distanciaD && distanciaU <= distanciaL && distanciaU <= distanciaR)
			return 'U';
		else if (distanciaL <= distanciaD && distanciaL <= distanciaU && distanciaL <= distanciaR)
			return 'L';
		else if (distanciaD <= distanciaU && distanciaD <= distanciaL && distanciaD <= distanciaR)
			return 'D';
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
