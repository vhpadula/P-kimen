package ClassesGerais;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	private Controle controle;

	public KeyInput(Controle ctrl) {
		this.controle = ctrl;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < controle.objetos.size(); i++) {
			ObjetoJogo temp = controle.objetos.get(i);
			if (temp.getID() == ID.Pacman) {

				temp.setVAnterior();

				if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
					if (temp.Vy != -(temp.velocidade)) {
						temp.movimentoDesejado = "U";
					}
					temp.setVy(-(temp.velocidade));
					temp.setVx(0);
					temp.setImage(temp.up);
				}
				if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
					if (temp.Vy != temp.velocidade) {
						temp.movimentoDesejado = "D";
					}
					temp.setVy(temp.velocidade);
					temp.setVx(0);
					temp.setImage(temp.down);
				}
				if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
					if (temp.Vx != -temp.velocidade) {
						temp.movimentoDesejado = "L";
					}
					temp.setVx(-(temp.velocidade));
					temp.setVy(0);
					temp.setImage(temp.left);
				}
				if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
					if (temp.Vx != temp.velocidade) {
						temp.movimentoDesejado = "R";
					}
					temp.setVx(temp.velocidade);
					temp.setVy(0);
					temp.setImage(temp.right);
				}
			}
		}
		if (key == KeyEvent.VK_ESCAPE)
			System.exit(1);
	}

}
