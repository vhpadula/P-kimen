import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HUD {
	private static int pontos = 0;
	public static int vidas = 2;
	Font pontosFont;
	String imagePath = SetPath.setPath("characters/pacman_right.png");
	BufferedImage textura;

	HUD() {
		try {
			pontosFont = Font.createFont(Font.TRUETYPE_FONT, new File(SetPath.setPath("fonts/PixelFont.ttf")))
					.deriveFont(20f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(SetPath.setPath("fonts/PixelFont.ttf"))));
		} catch (IOException | FontFormatException e) {
			System.out.println(e);
		}
	}

	public static void setPontos(int x) {
		pontos += x;
	}

	public static void setVidas(int x) {
		vidas -= x;
	}

	public void tick() {
	}

	public void render(Graphics g) {
		g.setFont(pontosFont);
		g.setColor(Color.white);
		g.drawString("Pontos ", 0, 30);
		g.drawString(Integer.toString(pontos), 140, 30);
		g.drawString("Vidas", 620, 30);
		try {
			textura = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			System.out.println(e);
		}
		renderVidas(g, vidas);
	}

	public void renderVidas(Graphics g, int vidas) {
		int x = 710 + vidas * 30;
		for (int i = 1; i <= vidas; i++, x -= 30) {
			g.drawImage(textura, x, 15, 25, 15, null);
		}
	}
}
