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

	protected char sortearDirecao(ObjetoJogo tempObject) {
		Random rand = new Random();
		int aleatorio = rand.nextInt();
		if (aleatorio < 0) {
			aleatorio *= -1;
		}
		char direcao = tempObject.cruzamento.toCharArray()[aleatorio % tempObject.cruzamento.length()];
		return direcao;
	}

	protected void cruzamento(ObjetoJogo tempObject) {
		if (tempObject.getID() == ID.Cruzamento) {
			double xCruzamento = tempObject.getBounds().getCenterX();
			double yCruzamento = tempObject.getBounds().getCenterY();
			double xFantasma = fantasma.getBounds().getCenterX();
			double yFantasma = fantasma.getBounds().getCenterY();
			if ((xFantasma == xCruzamento - 1.5 && yFantasma == yCruzamento - 1.5)
					|| (xFantasma == xCruzamento - 1.5 && yFantasma == yCruzamento - 0.5)) {

				char direcao = sortearDirecao(tempObject);

				if (fantasma.VyFantasma > 0) {
					while (direcao == 'U')
						direcao = sortearDirecao(tempObject);
				} else if (fantasma.VyFantasma < 0) {
					while (direcao == 'D')
						direcao = sortearDirecao(tempObject);
				} else if (fantasma.VxFantasma > 0) {
					while (direcao == 'L')
						direcao = sortearDirecao(tempObject);
				} else if (fantasma.VxFantasma < 0) {
					while (direcao == 'R')
						direcao = sortearDirecao(tempObject);
				}

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
