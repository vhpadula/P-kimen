package ClassesPersonagens;

import java.util.Random;

import ClassesGerais.Controle;
import ClassesGerais.ObjetoJogo;

public class MovimentacaoAleatoria implements MovimentacaoFantasma {

	Controle controle;
	Fantasmas fantasma;

	public MovimentacaoAleatoria(Controle controle, Fantasmas fantasma) {
		this.fantasma = fantasma;
		this.controle = controle;
	}

	public void movimentoAleatorio(ObjetoJogo tempObject) {
		char direcao = sorteiaDirecao(tempObject);
		if (fantasma.VxFantasma > 0) {
			while (direcao == 'L')
				direcao = sorteiaDirecao(tempObject);
		} else if (fantasma.VxFantasma < 0) {
			while (direcao == 'R')
				direcao = sorteiaDirecao(tempObject);
		} else if (fantasma.VyFantasma > 0) {
			while (direcao == 'D')
				direcao = sorteiaDirecao(tempObject);
		} else {
			while (direcao == 'U')
				direcao = sorteiaDirecao(tempObject);
		}
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
	
	protected char sorteiaDirecao(ObjetoJogo tempObject) {
		Random rand = new Random();
		int aleatorio = rand.nextInt();
		if (aleatorio < 0) {
			aleatorio *= -1;
		}
		char direcao = tempObject.cruzamento.toCharArray()[aleatorio % tempObject.cruzamento.length()];
		return direcao;
	}

	@Override
	public void movimentar() {
		for (int i = 0; i < controle.objetos.size(); i++) {
			ObjetoJogo tempObject = controle.objetos.get(i);
			movimentoAleatorio(tempObject);
			fantasma.colisao(tempObject);
		}
	}

}
