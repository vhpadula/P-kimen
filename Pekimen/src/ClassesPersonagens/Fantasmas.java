package ClassesPersonagens;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesGerais.Jogo;
import ClassesGerais.ObjetoJogo;
import ClassesInterface.HUD;
import ClassesTabuleiro.Mapa;

public abstract class Fantasmas extends ObjetoJogo {
	int VxFantasma;
	int VyFantasma;

	Fantasmas(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma, int VyFantasma) {
		super(x, y, id, controle, cruzamento);
		this.VxFantasma = VxFantasma;
		this.VyFantasma = VyFantasma;
	}

	int xInicial = x;
	int yInicial = y;
	boolean gaiola = true;
	int pontosIniciais = HUD.pontos;

	@Override
	public abstract void tick();

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, x, y, 30, 20, null);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 30, 20);
	}

	protected void teleporte() {
		x = Jogo.teleporte(x, 0, 846);
		y = Jogo.teleporte(y, 42, 680);
	}

	protected void movimentacao() {
		for (int i = 0; i < controle.objetos.size(); i++) {
			ObjetoJogo tempObject = controle.objetos.get(i);
			cruzamento(tempObject);
			colisao(tempObject);
		}
	}

	protected void movimentacaoGaiola() {
		for (int i = 0; i < controle.objetos.size(); i++) {
			ObjetoJogo tempObject = controle.objetos.get(i);
			if (tempObject.getID() == ID.Parede) {
				if (getBounds().intersects(tempObject.getBounds())) {
					x -= VxFantasma;
					y -= VyFantasma;

					VyFantasma *= -1;
				}
			}
		}
	}

	protected void sairGaiola(Fantasmas fantasma) {
		if (fantasma.getClass().toString().contains("Rosa")) {
			VyFantasma = -1;
			if (fantasma.getY() == this.yInicial - 63) {
				gaiola = false;
				fantasma.VxFantasma = setVInicial();
				fantasma.VyFantasma = 0;
			}
		} else if (fantasma.getClass().toString().contains("Azul")) {
			fantasma.VxFantasma = 1;
			fantasma.VyFantasma = 0;
			if (fantasma.getX() == this.xInicial + 30) {
				fantasma.VxFantasma = 0;
				fantasma.VyFantasma = -1;
			}
			if (fantasma.getY() == this.yInicial - 63) {
				gaiola = false;
				fantasma.VxFantasma = setVInicial();
				fantasma.VyFantasma = 0;
			}
		} else if (fantasma.getClass().toString().contains("Laranja")) {
			fantasma.VxFantasma = -1;
			fantasma.VyFantasma = 0;
			if (fantasma.getX() == this.xInicial - 30) {
				fantasma.VxFantasma = 0;
				fantasma.VyFantasma = -1;
			}
			if (fantasma.getY() == this.yInicial - 63) {
				gaiola = false;
				fantasma.VxFantasma = setVInicial();
				fantasma.VyFantasma = 0;
			}
		} else {
			gaiola = false;
			fantasma.VxFantasma = setVInicial();
		}
	}

	protected int setVInicial() {
		Random rand = new Random();
		int aleatorio = rand.nextInt();
		if (aleatorio % 2 == 1)
			return -2;
		else
			return 2;
	}

	protected void cruzamento(ObjetoJogo tempObject) {
		Random rand = new Random();
		if (tempObject.getID() == ID.Cruzamento) {
			double xCruzamento = tempObject.getBounds().getCenterX();
			double yCruzamento = tempObject.getBounds().getCenterY();
			double xFantasma = getBounds().getCenterX();
			double yFantasma = getBounds().getCenterY();
			if ((xFantasma == xCruzamento - 1.5 && yFantasma == yCruzamento - 1.5)
					|| (xFantasma == xCruzamento - 1.5 && yFantasma == yCruzamento - 0.5)) {

				int aleatorio = rand.nextInt();
				if (aleatorio < 0) {
					aleatorio *= -1;
				}
				char direcao = tempObject.cruzamento.toCharArray()[aleatorio % tempObject.cruzamento.length()];

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

	protected void colisao(ObjetoJogo tempObject) {
		if (tempObject.getID() == ID.Parede) {
			if (getBounds().intersects(tempObject.getBounds())) {
				if (!(tempObject.cruzamento == "U" && VyFantasma < 0)) {
					x -= VxFantasma;
					y -= VyFantasma;

					if (VxFantasma != 0) {
						VxFantasma = 0;
						if (vAnterior == "H" || vAnterior == null) {
							VyFantasma = 0;
						} else {
							VyFantasma = valorVAnterior;
							vAnterior = "V";
							// if (VyFantasma > 0) {
							// setImage("characters/pacman_down.png");
							// } else {
							// setImage("characters/pacman_up.png");
							// }
						}
					} else {
						VyFantasma = 0;
						if (vAnterior == "V" || vAnterior == null) {
							VxFantasma = 0;
						} else {
							VxFantasma = valorVAnterior;
							vAnterior = "H";
							// if (VxFantasma > 0) {
							// setImage("characters/pacman_right.png");
							// } else {
							// setImage("characters/pacman_left.png");
							// }
						}
					}
				}
			}
		}
	}
}
