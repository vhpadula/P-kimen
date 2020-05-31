import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Menu extends MouseAdapter {

	private Jogo jogo;
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

		// botao Back para Settings
		if (jogo.estadoJogo == ESTADO.Settings) {
			if (mouseOver(mx, my, 325, 500, 200, 70)) {
				jogo.estadoJogo = ESTADO.Menu;
			}
		}
	}

	public void mouseReleased(MouseEvent e) {

	}

	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
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
		if (jogo.estadoJogo == ESTADO.Menu) {
			g.setColor(Color.white);
			Font fonte;
			fonte = Font.createFont(Font.TRUETYPE_FONT, new File(SetPath.setPath("fonts/PixelFont.ttf")))
					.deriveFont(60f);
			Font fonteMenor;
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
			g.setColor(Color.white);
			Font fonte;
			fonte = Font.createFont(Font.TRUETYPE_FONT, new File(SetPath.setPath("fonts/PixelFont.ttf")))
					.deriveFont(50f);
			Font fonteMenor;
			fonteMenor = Font.createFont(Font.TRUETYPE_FONT, new File(SetPath.setPath("fonts/PixelFont.ttf")))
					.deriveFont(40f);
			g.setFont(fonte);
			g.drawString("Settings", 225, 130);

			// botao Back
			g.setFont(fonteMenor);
			g.drawRect(325, 500, 200, 70);
			g.drawString("Back", 344, 550);
		}
	}

}
