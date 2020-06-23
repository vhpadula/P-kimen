package ClassesInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import ClassesGerais.SetPath;

public class Settings {

	public void render(Graphics g) throws FontFormatException, IOException {
		Font fonte, fonteMenor;
		fonte = Font.createFont(Font.TRUETYPE_FONT, new File(SetPath.setPath("fonts/PixelFont.ttf"))).deriveFont(50f);
		fonteMenor = Font.createFont(Font.TRUETYPE_FONT, new File(SetPath.setPath("fonts/PixelFont.ttf")))
				.deriveFont(40f);
		g.setColor(Color.white);
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
