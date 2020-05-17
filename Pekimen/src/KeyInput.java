import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	private Controle controle;
	
	public KeyInput(Controle ctrl) {
		this.controle=ctrl;
	}
	
	public void keyPressed (KeyEvent e) {
		int key= e.getKeyCode();
		
		for(int i=0; i<controle.objetos.size();i++) {
			ObjetoJogo temp= controle.objetos.get(i);
			if (temp.id==ID.Pacman) {
				
				
				if (key==KeyEvent.VK_W) {
					temp.setVy(-1);
					temp.setVx(0);
				}
				if (key==KeyEvent.VK_S) {
					temp.setVy(1);
					temp.setVx(0);
				}
				if (key==KeyEvent.VK_A) {
					temp.setVx(-1);
					temp.setVy(0);
				}
				if (key==KeyEvent.VK_D) {
					temp.setVx(1);
					temp.setVy(0);
				}
			}
		}
	}
	
	public void KeyReleased(KeyEvent e) {
		
	}
}
