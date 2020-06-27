package ClassesPersonagens;

import java.awt.Graphics;

import ClassesGerais.Controle;
import ClassesGerais.ID;

public abstract class DecoratorFantasma extends Fantasmas {
	Fantasmas fantaDecorado;

	DecoratorFantasma(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma, int VyFantasma,
			Fantasmas fantaDecorado) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);

		this.fantaDecorado = fantaDecorado;

		this.geral = new MovimentacaoGeral(super.controle, this);
		this.scatter = fantaDecorado.scatter;
		this.chase = fantaDecorado.chase;
		this.VxFantasma = fantaDecorado.VxFantasma;
		this.VyFantasma = fantaDecorado.VyFantasma;
		this.Vx = fantaDecorado.Vx;
		this.Vy = fantaDecorado.Vy;
		this.vAnterior = fantaDecorado.vAnterior;
		this.valorVAnterior = fantaDecorado.valorVAnterior;
		this.movimentoDesejado = fantaDecorado.movimentoDesejado;
		this.xInicial = fantaDecorado.xInicial;
		this.yInicial = fantaDecorado.yInicial;
		this.velocidade = fantaDecorado.velocidade;
		this.gaiola = fantaDecorado.gaiola;
		this.pontosIniciais = fantaDecorado.pontosIniciais;
		this.pontosNecessarios = fantaDecorado.pontosNecessarios;
		this.up = fantaDecorado.up;
		this.down = fantaDecorado.down;
		this.left = fantaDecorado.left;
		this.right = fantaDecorado.right;
		if (fantaDecorado.Vx > 0) {
			this.setImage(fantaDecorado.right);
		} else if (fantaDecorado.Vx < 0) {
			this.setImage(fantaDecorado.left);
		} else if (fantaDecorado.Vy > 0) {
			this.setImage(fantaDecorado.down);
		} else if (fantaDecorado.Vy < 0) {
			this.setImage(fantaDecorado.up);
		}
		this.comestivel = fantaDecorado.comestivel;
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	public void render(Graphics g) {
		super.render(g);
	}
}
