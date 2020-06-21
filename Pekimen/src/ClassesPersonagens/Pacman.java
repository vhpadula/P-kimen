package ClassesPersonagens;

import java.awt.Graphics;
import java.awt.Rectangle;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesGerais.Jogo;
import ClassesGerais.ObjetoJogo;
import ClassesInterface.HUD;

public abstract class Pacman extends ObjetoJogo {

	Controle controle;
	int xInicial;
	int yInicial;
	int tempoRapido = 3;
	int tempoColetor = 3;
	int segundosRapido = 0;
	int segundosColetor = 0;

	public Pacman(int x, int y, ID id, Controle controle, String cruzamento) {
		super(x, y, id, controle, cruzamento);
		this.controle = controle;
		this.xInicial = x;
		this.yInicial = y;

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
		y = Jogo.teleporte(y, 42, 680);
		movimentacao();
		controle.xPacman = x;
		controle.yPacman = y;
		if (Vy > 0) {
			controle.direcaoPacman = 'D';
		} else if (Vy < 0) {
			controle.direcaoPacman = 'U';
		} else if (Vx < 0) {
			controle.direcaoPacman = 'L';
		} else if (Vx > 0) {
			controle.direcaoPacman = 'R';
		}

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, x, y, 30, 20, null);
	}

	void movimentacao() {
		for (int i = 0; i < controle.objetos.size(); i++) {
			ObjetoJogo tempObject = controle.objetos.get(i);
			cruzamento(tempObject);
			colisao(tempObject);
			comePastilha(tempObject, i);
			colisaoFantasma(tempObject);
			comeCereja(tempObject, i);
			comePilula(tempObject, i);
			comeIma(tempObject, i);
			comeFantasma(tempObject, i);
		}
	}

	void cruzamento(ObjetoJogo tempObject) {
		if (tempObject.getID() == ID.Cruzamento) {
			double xCruzamento = tempObject.getBounds().getCenterX();
			double yCruzamento = tempObject.getBounds().getCenterY();
			double xPacman = getBounds().getCenterX();
			double yPacman = getBounds().getCenterY();
			if ((xPacman == xCruzamento - 1.5 && yPacman == yCruzamento - 1.5)
					|| (xPacman == xCruzamento - 1.5 && yPacman == yCruzamento - 0.5)) {
				if (movimentoDesejado == "U" && tempObject.cruzamento.contains("U")) {
					Vx = 0;
					Vy = -(this.velocidade);
					setImage(up);
					vAnterior = "V";
				} else if (movimentoDesejado == "D" && tempObject.cruzamento.contains("D")) {
					Vx = 0;
					Vy = this.velocidade;
					setImage(down);
					vAnterior = "V";
				} else if (movimentoDesejado == "R" && tempObject.cruzamento.contains("R")) {
					Vx = this.velocidade;
					Vy = 0;
					setImage(right);
					vAnterior = "H";
				} else if (movimentoDesejado == "L" && tempObject.cruzamento.contains("L")) {
					Vx = -(this.velocidade);
					Vy = 0;
					setImage(left);
					vAnterior = "H";
				}
			}
		}
	}

	void colisao(ObjetoJogo tempObject) {
		if (tempObject.getID() == ID.Parede) {
			if (getBounds().intersects(tempObject.getBounds())) {
				if (!(tempObject.cruzamento == "U" && Vy < 0)) {
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
								setImage(down);
							} else {
								setImage(up);
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
								setImage(right);
							} else {
								setImage(left);
							}
						}
					}
				}
			}
		}
	}

	void colisaoFantasma(ObjetoJogo tempObject) {
		if (tempObject.getID() == ID.Fantasma) {
			Fantasmas temp = (Fantasmas) tempObject;
			if (!temp.comestivel) {
				if (getBounds().intersects(tempObject.getBounds())) {
					HUD.setVidas(1);
					x = xInicial;
					y = yInicial;
					setImage(right);
					Vx = 0;
					Vy = 0;
				}
				
			}
		}
	}

	void comePastilha(ObjetoJogo tempObject, int i) {
		if (tempObject.getID() == ID.Pastilha) {
			if (getBounds().intersects(tempObject.getBounds())) {
				controle.objetos.remove(i);
				HUD.setPontos(10);
				super.setNumeroPastilhas();
			}
		}
	}

	void comeCereja(ObjetoJogo tempObject, int i) {
		if (tempObject.getID() == ID.Cereja) {
			if (getBounds().intersects(tempObject.getBounds())) {
				controle.objetos.remove(i);

				HUD.setPontos(20);

				/*
				 * Timer timer = new Timer(); TimerTask task = new TimerTask() { public void
				 * run() { secondsPassed++; } }; timer.scheduleAtFixedRate(task, 1000, 1000);
				 * DecoratorSpeedUp speed = new DecoratorSpeedUp(0, 0, ID.Cereja, this.controle,
				 * ""); speed.setVel(this);
				 */

				for (int j = 0; j < controle.objetos.size(); j++) {
					if (controle.objetos.get(j).getID() == ID.Pacman) {
						Pacman temp = (Pacman) controle.objetos.get(j);

						controle.objetos.set(j,
								new Rapido(this.x, this.y, ID.Pacman, this.controle, this.cruzamento, temp));

					}
				}
			}
		}
	}

	void comeIma(ObjetoJogo tempObject, int i) {
		if (tempObject.getID() == ID.Ima) {
			if (getBounds().intersects(tempObject.getBounds())) {
				controle.objetos.remove(i);
				HUD.setPontos(20);
				for (int j = 0; j < controle.objetos.size(); j++) {
					if (controle.objetos.get(j).getID() == ID.Pacman) {
						Pacman temp = (Pacman) controle.objetos.get(j);
						controle.objetos.set(j,
								new Coletor(this.x, this.y, ID.Pacman, this.controle, this.cruzamento, temp));

					}
				}
			}
		}
	}

	void comePilula(ObjetoJogo tempObject, int i) {
		if (tempObject.getID() == ID.Pilula) {
			if (getBounds().intersects(tempObject.getBounds())) {
				controle.objetos.remove(i);
				HUD.setPontos(50);
				for(int j=0; j<controle.objetos.size(); j++) {
					
					if(controle.objetos.get(j).getID()==ID.Fantasma) {
						Fantasmas temp= (Fantasmas) controle.objetos.get(j);
						controle.objetos.set(j, new FantasmaAssustado (temp.x,temp.y,temp.getID(),temp.controle,temp.cruzamento,
								temp.Vx, temp.Vy, temp, j));
					}
				}
			}
			
			
		}
	}
	
	void comeFantasma(ObjetoJogo tempObject, int k) {
		if (tempObject.getID() == ID.Fantasma) {
			Fantasmas temp = (Fantasmas) tempObject;
				if (getBounds().intersects(tempObject.getBounds())) {
					
					if(temp.comestivel) {
						
					FantasmaAssustado tempA=  (FantasmaAssustado) temp;
					
					HUD.setPontos(200);
					
					
					if (tempA.fantaDecorado instanceof FantasmaAzul) {
					
						controle.jogo.mapa.fabrica.fazFantasmaAzul(tempA.fantaDecorado.xInicial, tempA.fantaDecorado.yInicial, 'a', k);
	
						
					}
					
					if (tempA.fantaDecorado instanceof FantasmaVermelho) {
						
						controle.jogo.mapa.fabrica.fazFantasmaVermelho(tempA.fantaDecorado.xInicial, tempA.fantaDecorado.yInicial, 'v', k);
						
					
					}
					
					if (tempA.fantaDecorado instanceof FantasmaLaranja) {
						
						controle.jogo.mapa.fabrica.fazFantasmaLaranja(tempA.fantaDecorado.xInicial, tempA.fantaDecorado.yInicial, 'l', k);
						
						
					}
					
					if (tempA.fantaDecorado instanceof FantasmaRosa) {
						
						controle.jogo.mapa.fabrica.fazFantasmaRosa(tempA.fantaDecorado.xInicial, tempA.fantaDecorado.yInicial, 'r', k);
						
						
					}
				}
				}
			
			
		}
	}
}
