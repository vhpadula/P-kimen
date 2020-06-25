package ClassesPersonagens;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesGerais.ObjetoJogo;
import ClassesInterface.HUD;

public class Coletor extends DecoratorPacman {

	public Coletor(int x, int y, ID id, Controle controle, String cruzamento, Pacman pacDecorado) {
		super(x, y, id, controle, cruzamento, pacDecorado);
		this.segundosColetor=0;
		Timer timerc = new Timer();
		TimerTask taskc = new TimerTask() {
			public void run() {
				segundosColetor++;
				segundosRapido++;
			}
		};
		timerc.scheduleAtFixedRate(taskc, 1000, 1000);
	}
	
	Rectangle boundsIma() {
		if (segundosColetor > tempoColetor) {
			return getBounds();
		}
		return new Rectangle(x-75, y-75, 150, 150);

	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
		if (segundosColetor < tempoColetor) {
			g.drawRect(x-75, y-75, 150, 150);
		}
		
	}
	
	@Override
	public void tick() {
		super.tick();
		
		
	}
	
	@Override
	void comePastilha(ObjetoJogo tempObject, int i) {
		if (tempObject.getID() == ID.Pastilha) {
			if (boundsIma().intersects(tempObject.getBounds())) {
				controle.objetos.remove(i);
				HUD.setPontos(10);
				controle.numeroPastilhas--;
			}
		}
	}
}
