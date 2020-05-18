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

				if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
					temp.setVy(-1);
					temp.setVx(0);
				}
				if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
					temp.setVy(1);
					temp.setVx(0);
				}
				if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
					temp.setVx(-1);
					temp.setVy(0);
				}
				if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
					temp.setVx(1);
					temp.setVy(0);
				}
			}
		}
	}

}
