import java.awt.Canvas;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Janela extends Canvas{

	private static final long serialVersionUID = 1L;
	
	public Janela (int largura, int altura, String titulo, Jogo jogo) throws IOException {
		JFrame frame = new JFrame(titulo);
		
		frame.setPreferredSize(new Dimension(largura, altura));
		frame.setMaximumSize(new Dimension(largura, altura));
		frame.setMinimumSize(new Dimension(largura, altura));
		frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/scenarios/Classic.png")))));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); //por enquanto vou deixar sem poder mudar de tamanho
		//se souberem adaptar tamanhos podem mudar para true
		frame.setLocationRelativeTo(null);
		frame.add(jogo);
		frame.setVisible(true);
		jogo.iniciar();
		
	}
}
