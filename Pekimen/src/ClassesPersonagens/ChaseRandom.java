package ClassesPersonagens;

import java.util.Random;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesGerais.ObjetoJogo;

public class ChaseRandom implements MovimentacaoFantasma {

	Controle controle;
	Fantasmas fantasma;

	public ChaseRandom(Controle controle, Fantasmas fantasma) {
		this.fantasma = fantasma;
		this.controle = controle;
	}

	@Override
	public void movimentar() {
		for (int i = 0; i < controle.objetos.size(); i++) {
			ObjetoJogo tempObject = controle.objetos.get(i);
			cruzamento(tempObject);
		}
	}

	protected void cruzamento(ObjetoJogo tempObject) {
		Random rand = new Random();
		if (tempObject.getID() == ID.Cruzamento) {
			double xCruzamento = tempObject.getBounds().getCenterX();
			double yCruzamento = tempObject.getBounds().getCenterY();
			double xFantasma = fantasma.getBounds().getCenterX();
			double yFantasma = fantasma.getBounds().getCenterY();
			if ((xFantasma == xCruzamento - 1.5 && yFantasma == yCruzamento - 1.5)
					|| (xFantasma == xCruzamento - 1.5 && yFantasma == yCruzamento - 0.5)) {

				int aleatorio = rand.nextInt();
				if (aleatorio < 0) {
					aleatorio *= -1;
				}
				char direcao = tempObject.cruzamento.toCharArray()[aleatorio % tempObject.cruzamento.length()];

				if (direcao == 'U') {
					fantasma.VxFantasma = 0;
					fantasma.VyFantasma = -1 * fantasma.velocidade;
					fantasma.vAnterior = "V";
				} else if (direcao == 'D') {
					fantasma.VxFantasma = 0;
					fantasma.VyFantasma = fantasma.velocidade;
					fantasma.vAnterior = "V";
				} else if (direcao == 'R') {
					fantasma.VxFantasma = fantasma.velocidade;
					fantasma.VyFantasma = 0;
					fantasma.vAnterior = "H";
				} else if (direcao == 'L') {
					fantasma.VxFantasma = -1 * fantasma.velocidade;
					fantasma.VyFantasma = 0;
					fantasma.vAnterior = "H";
				}
			}
		}
	}
}
