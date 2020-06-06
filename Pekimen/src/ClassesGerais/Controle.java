package ClassesGerais;

import java.awt.Graphics;
import java.util.ArrayList;

public class Controle {
	public ArrayList<ObjetoJogo> objetos = new ArrayList<ObjetoJogo>();
	public double xPacman, yPacman;

	public void tick() {
		for (int i = 0; i < objetos.size(); i++) {
			ObjetoJogo temp = objetos.get(i);
			temp.tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < objetos.size(); i++) {
			ObjetoJogo temp = objetos.get(i);
			temp.render(g);
		}
	}

	public void addObjeto(ObjetoJogo o) {
		this.objetos.add(o);
	}

	public void removeObjeto(ObjetoJogo o) {
		this.objetos.remove(o);
	}

	public void setPosicaoPacman(double x, double y){
		xPacman = x;
		yPacman = y;
	}
}
