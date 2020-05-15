import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Janela extends Canvas{

	private static final long serialVersionUID = 1L;
	JFrame frame;//coloquei eles como atributo da classes para serem acessados quando o jogo tiver rodando
	Image imagem;
	public Janela (int largura, int altura, String titulo, Jogo jogo) throws IOException {
		frame = new JFrame(titulo);
		String imagePath;
		String sistemaOperacional = System.getProperty("os.name");
		if (sistemaOperacional.contains("Windows")) {
			imagePath = "src/scenarios/Classic.png";
		} else {
			imagePath = "scenarios/Classic.png";
		}

		imagem = ImageIO.read(new File(imagePath));
		frame.setPreferredSize(new Dimension(largura, altura));
		frame.setMaximumSize(new Dimension(largura, altura));
		frame.setMinimumSize(new Dimension(largura, altura));
		frame.setContentPane(new JLabel(new ImageIcon(imagem)));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.add(jogo);
		frame.setVisible(true);
		jogo.iniciar();
		
	}
}
