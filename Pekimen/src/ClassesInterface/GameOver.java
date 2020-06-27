package ClassesInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import ClassesGerais.SetPath;

public class GameOver {
	HUD hud;
	
	public GameOver(HUD hud) {
		this.hud = hud;
	}

	public void tick() {

	}

	public void render(Graphics g) throws FontFormatException, IOException {
		Font fonte, fonteMenor;
		fonte = Font.createFont(Font.TRUETYPE_FONT, new File(SetPath.setPath("fonts/PixelFont.ttf"))).deriveFont(60f);
		fonteMenor = Font.createFont(Font.TRUETYPE_FONT, new File(SetPath.setPath("fonts/PixelFont.ttf")))
				.deriveFont(38f);
		g.setFont(fonte);
		g.setColor(Color.WHITE);
		g.drawString("GAME OVER", 150, 240);
		g.setFont(fonteMenor);
		g.drawString("PONTOS: " + HUD.pontos, 220, 340);
		g.drawString("RESTART", 290, 450);
		g.drawRect(270, 400, 306, 70);
		
	}
}
