import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Menu extends MouseAdapter {

	protected Jogo jogo;
	private Controle controle;
	Mapa mapa;

	public Menu(Jogo jogo, Controle controle, Mapa mapa) {
		this.jogo = jogo;
		this.controle = controle;
		this.mapa = mapa;
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		// botao Play
		if (jogo.estadoJogo == ESTADO.Menu) {
			if (mouseOver(mx, my, 263, 260, 320, 80)) {
				jogo.estadoJogo = ESTADO.Jogo;
				mapa = new Mapa(true, controle, jogo);
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
				jogo.estadoJogo = ESTADO.Menu;
			}
		}

		// botao Selva
		if (jogo.estadoJogo == ESTADO.Settings) {
			if (mouseOver(mx, my, 490, 230, 225, 70)) {
				jogo.estadoJogo = ESTADO.Menu;
			}
		}

		// botao Supermercado
		if (jogo.estadoJogo == ESTADO.Settings) {
			if (mouseOver(mx, my, 170, 350, 506, 70)) {
				jogo.estadoJogo = ESTADO.Menu;
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
		} else if (jogo.estadoJogo == ESTADO.Settings) {
			fonte = Font.createFont(Font.TRUETYPE_FONT, new File(SetPath.setPath("fonts/PixelFont.ttf")))
					.deriveFont(50f);
			fonteMenor = Font.createFont(Font.TRUETYPE_FONT, new File(SetPath.setPath("fonts/PixelFont.ttf")))
					.deriveFont(40f);
			g.setFont(fonte);
			g.drawString("Settings", 225, 130);

			g.setFont(fonteMenor);
			g.drawRect(490, 230, 225, 70);
			g.drawString("Selva", 500, 280);

			g.drawRect(170, 350, 506, 70);
			g.drawString("Supermercado", 180, 400);

			g.drawRect(120, 230, 307, 70);
			g.drawString("Classic", 130, 280);

			g.drawRect(325, 500, 200, 70);
			g.drawString("Back", 344, 550);
		}
	}

}
