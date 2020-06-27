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
	boolean gaiola = true;
	int pontosIniciais = HUD.pontos;
	int pontosNecessarios;
	int segundosAssustado = 0;

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
		geral.teleporte();
		geral.movimentar();
		if (!comestivel) {
			chase.movimentar();
			SetTexture(VyFantasma, VxFantasma);
		}
		else if(comestivel){
			aleatorio = new ChaseRandom(controle, this);
			aleatorio.movimentar();
			
		}
		
		
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
