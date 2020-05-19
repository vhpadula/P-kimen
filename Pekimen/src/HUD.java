import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class HUD {
		private static int pontos = 0;
		Font pontosFont;
		HUD(){
			try {
				pontosFont = Font.createFont(Font.TRUETYPE_FONT, new File(SetPath.setPath("fonts/PixelFont.ttf"))).deriveFont(20f);
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
				ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(SetPath.setPath("fonts/PixelFont.ttf"))));
			}catch(IOException | FontFormatException e) {
				System.out.println(e);
			}
		}
		public static void setPontos(int x) {
			pontos += x;
		}
		public void tick() {
		}
		
		public void render(Graphics g) {
			g.setFont(pontosFont);
			g.setColor(Color.white);
			g.drawString("Pontos ", 0, 30);
			g.drawString(Integer.toString(pontos), 140, 30);
		}
}
