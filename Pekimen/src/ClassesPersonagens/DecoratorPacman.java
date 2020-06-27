package ClassesPersonagens;

import java.awt.Graphics;
import java.awt.Rectangle;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesGerais.ObjetoJogo;

public abstract class DecoratorPacman extends Pacman {

	public Pacman pacDecorado;

	public DecoratorPacman(int x, int y, ID id, Controle controle, String cruzamento, Pacman pacDecorado) {
		super(x, y, id, controle, cruzamento);
		this.pacDecorado = pacDecorado;
		this.up = pacDecorado.up;
		this.down = pacDecorado.down;
		this.left = pacDecorado.left;
		this.right = pacDecorado.right;
		if (pacDecorado.Vx > 0) {
			this.setImage(pacDecorado.right);
		} else if (pacDecorado.Vx < 0) {
			this.setImage(pacDecorado.left);
		} else if (pacDecorado.Vy > 0) {
			this.setImage(pacDecorado.down);
		} else if (pacDecorado.Vy < 0) {
			this.setImage(pacDecorado.up);
		}
		this.Vx = pacDecorado.Vx;
		this.Vy = pacDecorado.Vy;
		this.vAnterior = pacDecorado.vAnterior;
		this.valorVAnterior = pacDecorado.valorVAnterior;
		this.movimentoDesejado = pacDecorado.movimentoDesejado;
		this.xInicial = pacDecorado.xInicial;
		this.yInicial = pacDecorado.yInicial;
		this.velocidade = pacDecorado.velocidade;
		this.tempoRapido = pacDecorado.tempoRapido;
		this.tempoColetor = pacDecorado.tempoColetor;
		this.segundosRapido = pacDecorado.segundosRapido;
		this.segundosColetor = pacDecorado.segundosColetor;
	}

	@Override
	public Rectangle getBounds() {
		return super.getBounds();
	}

	@Override
	public void tick() {
		super.tick();
		
	}

	@Override
	public void render(Graphics g) {
		super.render(g);
	}

	void movimentacao() {
		super.movimentacao();
	}

	void cruzamento(ObjetoJogo tempObject) {
		super.cruzamento(tempObject);
	}

	void colisao(ObjetoJogo tempObject) {
		super.colisao(tempObject);
	}

	void colisaoFantasma(ObjetoJogo tempObject) {
		super.colisaoFantasma(tempObject);
	}

	void comePastilha(ObjetoJogo tempObject, int i) {
		super.comePastilha(tempObject, i);
	}

	void comeCereja(ObjetoJogo tempObject, int i) {
		super.comeCereja(tempObject, i);
	}

	void comeIma(ObjetoJogo tempObject, int i) {
		super.comeIma(tempObject, i);
	}

	void comePilula(ObjetoJogo tempObject, int i) {
		super.comePilula(tempObject, i);
	}
}
