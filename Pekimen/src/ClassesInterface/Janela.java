package ClassesInterface;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import ClassesGerais.Jogo;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Janela extends Canvas {

	private static final long serialVersionUID = 1L;
	public JFrame frame;
	public BufferedImage imagem;

	public Janela(int largura, int altura, String titulo, Jogo jogo) throws IOException {
		frame = new JFrame(titulo);
		String imagePath = ClassesGerais.SetPath.setPath("scenarios/fundo.jpg");

		imagem = ImageIO.read(new File(imagePath));
		frame.setPreferredSize(new Dimension(largura, altura));
		frame.setMaximumSize(new Dimension(largura, altura));
		frame.setMinimumSize(new Dimension(largura, altura));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(jogo);
		frame.setVisible(true);
		jogo.iniciar();

	}

	public void setImage(String path) throws IOException {
		String imagePath = ClassesGerais.SetPath.setPath(path);
		imagem = ImageIO.read(new File(imagePath));
	}
}
