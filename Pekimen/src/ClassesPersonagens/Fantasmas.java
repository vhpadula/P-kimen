package ClassesPersonagens;

import java.awt.Graphics;
import java.awt.Rectangle;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesGerais.ObjetoJogo;
import ClassesInterface.HUD;

public abstract class Fantasmas extends ObjetoJogo {
	int VxFantasma;
	int VyFantasma;
	
	
	Fantasmas(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma, int VyFantasma) {
		super(x, y, id, controle, cruzamento);
		this.VxFantasma = VxFantasma;
		this.VyFantasma = VyFantasma;
		this.xInicial=x;
		this.yInicial=y;
	}

	int xInicial, yInicial;
	boolean gaiola;
	int pontosIniciais = HUD.pontos;
	int pontosNecessarios;
	
	boolean comestivel;
	boolean comido;
	
	MovimentacaoGeral geral;
	Scatter scatter;
	MovimentacaoFantasma chase;
	
	@Override
	public void tick() {
		x += VxFantasma;
		y += VyFantasma;
		if (gaiola && HUD.pontos >= pontosIniciais + pontosNecessarios)
			geral.sairGaiola(this);
		else
			geral.movimentacaoGaiola();
		chase.movimentar();
		geral.teleporte();
		geral.movimentar();
		SetTexture(VyFantasma, VxFantasma);
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(textura, x, y, 30, 20, null);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 30, 20);
	}
	
	public void SetTexture(int Vy, int Vx) {
		if(Vx > 0) setImage(right);
		else if(Vx < 0) setImage(left);
		else if(Vy < 0) setImage(up);
		else if(Vy > 0) setImage(down);
		
		
	}
	
	

	// Funções da movimentação aleatória
	/*protected char sorteiaDirecao(ObjetoJogo tempObject) {
		Random rand = new Random();
		int aleatorio = rand.nextInt();
		if (aleatorio < 0) {
			aleatorio *= -1;
		}
		char direcao = tempObject.cruzamento.toCharArray()[aleatorio % tempObject.cruzamento.length()];
		return direcao;
	}

	protected void aletorio(ObjetoJogo tempObject) {
		char direcao = sorteiaDirecao(tempObject);
		if (VxFantasma > 0) {
			while (direcao == 'L')
				direcao = sorteiaDirecao(tempObject);
		} else if (VxFantasma < 0) {
			while (direcao == 'R')
				direcao = sorteiaDirecao(tempObject);
		} else if (Vy > 0) {
			while (direcao == 'D')
				direcao = sorteiaDirecao(tempObject);
		} else {
			while (direcao == 'U')
				direcao = sorteiaDirecao(tempObject);
		}
		if (direcao == 'U') {
			VxFantasma = 0;
			VyFantasma = -2;
			vAnterior = "V";
		} else if (direcao == 'D') {
			VxFantasma = 0;
			VyFantasma = 2;
			vAnterior = "V";
		} else if (direcao == 'R') {
			VxFantasma = 2;
			VyFantasma = 0;
			vAnterior = "H";
		} else if (direcao == 'L') {
			VxFantasma = -2;
			VyFantasma = 0;
			vAnterior = "H";
		}
	}

	// Funções da movimentação do fantasma vermelho
	protected void movimentacaoVermelho() {
		for (int i = 0; i < controle.objetos.size(); i++) {
			ObjetoJogo tempObject = controle.objetos.get(i);
			cruzamentoVermelho(tempObject);
			colisao(tempObject);
		}
	}

	double getTargetVermelho(int x, int y) {
		double distancia = Math.sqrt(Math.pow(controle.xPacman - x, 2) + Math.pow(controle.yPacman - y, 2));
		return distancia;
	}

	protected char vermelhoChaseMode(ObjetoJogo tempObject) {
		double distanciaD = 10000000;
		double distanciaU = 10000000;
		double distanciaL = 10000000;
		double distanciaR = 10000000;

		if (tempObject.cruzamento.toString().contains("D") && !(VyFantasma < 0))
			distanciaD = getTargetVermelho(x, y + 1);
		if (tempObject.cruzamento.toString().contains("U") && !(VyFantasma > 0))
			distanciaU = getTargetVermelho(x, y - 1);
		if (tempObject.cruzamento.toString().contains("L") && !(VxFantasma > 0))
			distanciaL = getTargetVermelho(x - 1, y);
		if (tempObject.cruzamento.toString().contains("R") && !(VxFantasma < 0))
			distanciaR = getTargetVermelho(x + 1, y);

		if (distanciaD < distanciaU && distanciaD < distanciaL && distanciaD < distanciaR)
			return 'D';
		else if (distanciaU < distanciaD && distanciaU < distanciaL && distanciaU < distanciaR)
			return 'U';
		else if (distanciaL < distanciaU && distanciaL < distanciaD && distanciaL < distanciaR)
			return 'L';
		else
			return 'R';

	}

	protected void cruzamentoVermelho(ObjetoJogo tempObject) {
		if (tempObject.getID() == ID.Cruzamento) {
			double xCruzamento = tempObject.getBounds().getCenterX();
			double yCruzamento = tempObject.getBounds().getCenterY();
			double xFantasma = getBounds().getCenterX();
			double yFantasma = getBounds().getCenterY();
			if ((xFantasma == xCruzamento - 1.5 && yFantasma == yCruzamento - 1.5)
					|| (xFantasma == xCruzamento - 1.5 && yFantasma == yCruzamento - 0.5)) {
				char direcao = vermelhoChaseMode(tempObject);
				if (direcao == 'U') {
					VxFantasma = 0;
					VyFantasma = -2;
					vAnterior = "V";
				} else if (direcao == 'D') {
					VxFantasma = 0;
					VyFantasma = 2;
					vAnterior = "V";
				} else if (direcao == 'R') {
					VxFantasma = 2;
					VyFantasma = 0;
					vAnterior = "H";
				} else if (direcao == 'L') {
					VxFantasma = -2;
					VyFantasma = 0;
					vAnterior = "H";
				}
			}
		}
	}

	// Funções de movimentação do fantasma rosa
	protected void movimentacaoRosa() {
		for (int i = 0; i < controle.objetos.size(); i++) {
			ObjetoJogo tempObject = controle.objetos.get(i);
			cruzamentoRosa(tempObject);
			colisao(tempObject);
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

	protected char rosaChaseMode(ObjetoJogo tempObject) {
		double distanciaD = 10000000;
		double distanciaU = 10000000;
		double distanciaL = 10000000;
		double distanciaR = 10000000;
		char direcao = 'N';

		if (tempObject.cruzamento.toString().contains("D") && !(VyFantasma < 0))
			distanciaD = getTargetRosa(x, y + 3);
		if (tempObject.cruzamento.toString().contains("U") && !(VyFantasma > 0))
			distanciaU = getTargetRosa(x, y - 3);
		if (tempObject.cruzamento.toString().contains("L") && !(VxFantasma > 0))
			distanciaL = getTargetRosa(x - 3, y);
		if (tempObject.cruzamento.toString().contains("R") && !(VxFantasma < 0))
			distanciaR = getTargetRosa(x + 3, y);

		if (distanciaD < distanciaU && distanciaD < distanciaL && distanciaD < distanciaR && !(VyFantasma > 0))
			direcao = 'D';
		else if (distanciaU < distanciaD && distanciaU < distanciaL && distanciaU < distanciaR && !(VyFantasma < 0))
			direcao = 'U';
		else if (distanciaL < distanciaU && distanciaL < distanciaD && distanciaL < distanciaR && !(VxFantasma > 0))
			direcao = 'L';
		else if (distanciaR < distanciaD && distanciaR < distanciaU && distanciaR < distanciaL && !(VxFantasma < 0))
			direcao = 'R';

		return direcao;
	}

	protected void cruzamentoRosa(ObjetoJogo tempObject) {
		if (tempObject.getID() == ID.Cruzamento) {
			double xCruzamento = tempObject.getBounds().getCenterX();
			double yCruzamento = tempObject.getBounds().getCenterY();
			double xFantasma = getBounds().getCenterX();
			double yFantasma = getBounds().getCenterY();
			if ((xFantasma == xCruzamento - 1.5 && yFantasma == yCruzamento - 1.5)
					|| (xFantasma == xCruzamento - 1.5 && yFantasma == yCruzamento - 0.5)) {
				char direcao = rosaChaseMode(tempObject);
				if (direcao == 'U') {
					VxFantasma = 0;
					VyFantasma = -2;
					vAnterior = "V";
				} else if (direcao == 'D') {
					VxFantasma = 0;
					VyFantasma = 2;
					vAnterior = "V";
				} else if (direcao == 'R') {
					VxFantasma = 2;
					VyFantasma = 0;
					vAnterior = "H";
				} else if (direcao == 'L') {
					VxFantasma = -2;
					VyFantasma = 0;
					vAnterior = "H";
				}
			}
		}
	}*/
}
