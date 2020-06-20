package ClassesGerais;

public abstract class Nivel {
	public static int vPacman;
	public static int vFantasma;
	public Controle ctrl;
	
	
	public Nivel(Controle ctrl){
		this.ctrl=ctrl;
	}
	
	public void handle() {
		for (int i =0; i<ctrl.objetos.size(); i++) {
			if (ctrl.objetos.get(i).getID() == ID.Fantasma) {
				ctrl.objetos.get(i).velocidade=vFantasma;
			}
			
			if (ctrl.objetos.get(i).getID() == ID.Pacman) {
				ctrl.objetos.get(i).velocidade=vPacman;
			}
		}
	}
		
	
}
