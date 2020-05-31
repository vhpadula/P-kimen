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
		if (vidas == 1) {
			g.drawImage(textura, 740, 15, 25, 15, null);
		} else if (vidas == 2) {
			g.drawImage(textura, 770, 15, 25, 15, null);
			g.drawImage(textura, 740, 15, 25, 15, null);
		} else if (vidas == 3) {
			g.drawImage(textura, 800, 15, 25, 15, null);
			g.drawImage(textura, 770, 15, 25, 15, null);
			g.drawImage(textura, 740, 15, 25, 15, null);
		}
	}
}
