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
					if (temp.Vy != -2) {
						temp.movimentoDesejado = "U";
					}
					temp.setVy(-2);
					temp.setVx(0);
					temp.setImage(temp.up);
				}
				if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
					if (temp.Vy != 2) {
						temp.movimentoDesejado = "D";
					}
					temp.setVy(2);
					temp.setVx(0);
					temp.setImage(temp.down);
				}
				if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
					if (temp.Vx != -2) {
						temp.movimentoDesejado = "L";
					}
					temp.setVx(-2);
					temp.setVy(0);
					temp.setImage(temp.left);
				}
				if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
					if (temp.Vx != 2) {
						temp.movimentoDesejado = "R";
					}
					temp.setVx(2);
					temp.setVy(0);
					temp.setImage(temp.right);
				}
			}
		}
		if (key == KeyEvent.VK_ESCAPE)
			System.exit(1);
	}

}
