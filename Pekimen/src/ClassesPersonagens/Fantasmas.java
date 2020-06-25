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
		this.xInicial = x;
		this.yInicial = y;
	}

	int xInicial, yInicial;
	boolean gaiola;
	int pontosIniciais = HUD.pontos;
	int pontosNecessarios;

	protected boolean comestivel;
	boolean comido;

	MovimentacaoGeral geral;
	Scatter scatter;
	ChaseRandom aleatorio;
	MovimentacaoFantasma chase;

	@Override
	public void tick() {
		x += VxFantasma;
		y += VyFantasma;
		if (gaiola && HUD.pontos >= pontosIniciais + pontosNecessarios)
			geral.sairGaiola(this);
		else
			geral.movimentacaoGaiola();
		if (!comestivel) {
			chase.movimentar();
			if (this.getClass().toString().contains("Rosa")) {
			this.up = "Classic/pacman_up.png";
			this.down = "Classic/pacman_down.png";
			this.left = "Classic/pacman_left.png";
			this.right = "Classic/pacman_right.png";
			}
		}
		else {
			aleatorio = new ChaseRandom(controle, this);
			aleatorio.movimentar();
			this.up = "Classic/Assustado1.png";
			this.down = "Classic/Assustado1.png";
			this.left = "Classic/Assustado1.png";
			this.right = "Classic/Assustado1.png";
		}
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
		if (Vx > 0)
			setImage(right);
		else if (Vx < 0)
			setImage(left);
		else if (Vy < 0)
			setImage(up);
		else if (Vy > 0)
			setImage(down);
	}
}
