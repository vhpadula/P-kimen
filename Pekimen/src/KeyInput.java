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
				
				
				if (key==KeyEvent.VK_W) temp.setY(temp.y-1);
				if (key==KeyEvent.VK_S) temp.setY(temp.y+1);
				if (key==KeyEvent.VK_A) temp.setX(temp.x-1);
				if (key==KeyEvent.VK_D) temp.setX(temp.x+1);
			}
		}
	}
	
	public void KeyReleased(KeyEvent e) {
		
	}
}
