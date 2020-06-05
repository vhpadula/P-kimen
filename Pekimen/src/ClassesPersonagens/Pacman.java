package ClassesPersonagens;
import java.awt.Graphics;
import java.awt.Rectangle;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesGerais.Jogo;
import ClassesGerais.ObjetoJogo;
import ClassesInterface.HUD;
import ClassesTabuleiro.Mapa;

public class Pacman extends ObjetoJogo {

	Controle controle;

	public Pacman(int x, int y, String imagePath, ID id, Mapa mapa, Controle controle, String cruzamento) {
		super(x, y, imagePath, id, mapa, controle, cruzamento);
		this.controle = controle;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 30, 20);
	}

	@Override
	public void tick() {
		x += Vx;
		y += Vy;
		// abrange os casos de teleporte
		x = Jogo.teleporte(x, 0, 846);
		y = Jogo.teleporte(y, 42, 680); // teria que mudar o valor do teleporte tbm caso implemente a tela menor mesmo
		movimentacao();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, x, y, 30, 20, null);
	}

	private void movimentacao() {
		for (int i = 0; i < controle.objetos.size(); i++) {
			ObjetoJogo tempObject = controle.objetos.get(i);
			cruzamento(tempObject);
			colisao(tempObject);
			comePastilha(tempObject, i);
			colisaoFantasma(tempObject);
		}
	}

	private void cruzamento(ObjetoJogo tempObject) {
		if (tempObject.getID() == ID.Cruzamento) {
			double xCruzamento = tempObject.getBounds().getCenterX();
			double yCruzamento = tempObject.getBounds().getCenterY();
			double xPacman = getBounds().getCenterX();
			double yPacman = getBounds().getCenterY();
			if ((xPacman == xCruzamento - 1.5 && yPacman == yCruzamento - 1.5)
					|| (xPacman == xCruzamento - 1.5 && yPacman == yCruzamento - 0.5)) {
				if (movimentoDesejado == "U" && tempObject.cruzamento.contains("U")) {
					Vx = 0;
					Vy = -2;
					setImage("characters/pacman_up.png");
					vAnterior = "V";
				} else if (movimentoDesejado == "D" && tempObject.cruzamento.contains("D")) {
					Vx = 0;
					Vy = 2;
					setImage("characters/pacman_down.png");
					vAnterior = "V";
				} else if (movimentoDesejado == "R" && tempObject.cruzamento.contains("R")) {
					Vx = 2;
					Vy = 0;
					setImage("characters/pacman_right.png");
					vAnterior = "H";
				} else if (movimentoDesejado == "L" && tempObject.cruzamento.contains("L")) {
					Vx = -2;
					Vy = 0;
					setImage("characters/pacman_left.png");
					vAnterior = "H";
				}
			}
		}
	}

	private void colisao(ObjetoJogo tempObject) {
		if (tempObject.getID() == ID.Parede) {
			if (getBounds().intersects(tempObject.getBounds())) {
				if (!(tempObject.cruzamento == "U" && Vy == -2)) {
					x -= Vx;
					y -= Vy;

					if (Vx != 0) {
						Vx = 0;
						if (vAnterior == "H" || vAnterior == null) {
							Vy = 0;
						} else {
							Vy = valorVAnterior;
							vAnterior = "V";
							if (Vy > 0) {
								setImage("characters/pacman_down.png");
							} else {
								setImage("characters/pacman_up.png");
							}
						}
					} else {
						Vy = 0;
						if (vAnterior == "V" || vAnterior == null) {
							Vx = 0;
						} else {
							Vx = valorVAnterior;
							vAnterior = "H";
							if (Vx > 0) {
								setImage("characters/pacman_right.png");
							} else {
								setImage("characters/pacman_left.png");
							}
						}
					}
				}
			}
		}
	}

	private void colisaoFantasma(ObjetoJogo tempObject) {
		if (tempObject.getID() == ID.Fantasma) {
			if (getBounds().intersects(tempObject.getBounds())) {
				HUD.setVidas(1);
			}
		}
	}

	private void comePastilha(ObjetoJogo tempObject, int i) {
		if (tempObject.getID() == ID.Pastilha) {
			if (getBounds().intersects(tempObject.getBounds())) {
				controle.objetos.remove(i);
				HUD.setPontos(10);
			}
		}
	}
}
