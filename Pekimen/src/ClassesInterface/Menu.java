package ClassesInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import ClassesGerais.Controle;
import ClassesGerais.FabricaClassica;
import ClassesGerais.FabricaSelva;
import ClassesGerais.FabricaSupermercado;
import ClassesGerais.Jogo;
import ClassesGerais.SetPath;
import ClassesTabuleiro.Mapa;

public class Menu extends MouseAdapter {

	protected Jogo jogo;
	private Controle controle;
	Mapa mapa;
	HUD hud;

	public Menu(Jogo jogo, Controle controle, Mapa mapa, HUD hud) {
		this.jogo = jogo;
		this.controle = controle;
		this.mapa = mapa;
		this.hud = hud;
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		// botao Play
		if (jogo.estadoJogo == ESTADO.Menu) {
			if (mouseOver(mx, my, 263, 260, 320, 80)) {
				jogo.estadoJogo = ESTADO.Jogo;
				
				mapa = new Mapa(true, controle, jogo, jogo.fabrica);
				try {
					mapa.constroiTabuleiro();			
				} catch (IOException ex) {

				}
			}
		}

		// botao Settings
		if (jogo.estadoJogo == ESTADO.Menu) {
			if (mouseOver(mx, my, 263, 400, 320, 80)) {
				jogo.estadoJogo = ESTADO.Settings;
			}
		}

		// botao Back
		if (jogo.estadoJogo == ESTADO.Settings) {
			if (mouseOver(mx, my, 325, 500, 200, 70)) {
				jogo.estadoJogo = ESTADO.Menu;
			}
		}

		// botao Classic
		if (jogo.estadoJogo == ESTADO.Settings) {
			if (mouseOver(mx, my, 120, 230, 307, 70)) {
				jogo.fabrica = new FabricaClassica(controle,jogo);
				try {
					jogo.fabrica.atualizaFundo();
					jogo.musica.para();
					jogo.fabrica.fazMusica();
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
					e1.printStackTrace();
				}
			}
		}

		// botao Selva
		if (jogo.estadoJogo == ESTADO.Settings) {
			if (mouseOver(mx, my, 490, 230, 225, 70)) {
				jogo.fabrica = new FabricaSelva(controle,jogo);
				try {
					jogo.musica.para();
					jogo.fabrica.atualizaFundo();
					jogo.fabrica.fazMusica();
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
					e1.printStackTrace();
				}
			}
		}

		// botao Supermercado
		if (jogo.estadoJogo == ESTADO.Settings) {
			if (mouseOver(mx, my, 170, 350, 506, 70)) {
				jogo.fabrica = new FabricaSupermercado(controle,jogo);
				try {
					jogo.fabrica.atualizaFundo();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

		// botao Restart
		if (jogo.estadoJogo == ESTADO.End) {
			if (mouseOver(mx, my, 270, 400, 306, 70)) {
				jogo.estadoJogo = ESTADO.Menu;
				HUD.pontos = 0;
			}
		}
	}

	protected boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < (x + width)) {
			if (my > y && my < (y + height)) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public void tick() {

	}

	public void render(Graphics g) throws FontFormatException, IOException {
		g.setColor(Color.white);
		Font fonte, fonteMenor;
		if (jogo.estadoJogo == ESTADO.Menu) {
			fonte = Font.createFont(Font.TRUETYPE_FONT, new File(SetPath.setPath("fonts/PixelFont.ttf")))
					.deriveFont(60f);
			fonteMenor = Font.createFont(Font.TRUETYPE_FONT, new File(SetPath.setPath("fonts/PixelFont.ttf")))
					.deriveFont(32f);
			g.setFont(fonte);
			g.drawString("Menu", 295, 180);

			// botao Play
			g.drawRect(263, 260, 320, 80);
			g.setFont(fonteMenor);
			g.drawString("Play", 355, 316);

			// botao Settings
			g.drawRect(263, 400, 320, 80);
			g.drawString("Settings", 295, 455);
		}
	}

}
