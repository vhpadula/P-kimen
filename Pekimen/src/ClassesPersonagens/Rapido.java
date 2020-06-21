package ClassesPersonagens;

import java.util.Timer;
import java.util.TimerTask;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import Niveis.Nivel;

public class Rapido extends DecoratorPacman {

	public Rapido(int x, int y, ID id, Controle controle, String cruzamento, Pacman pacDecorado) {
		super(x, y, id, controle, cruzamento, pacDecorado);
		this.segundosRapido = 0;
		Timer timerr = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				segundosRapido++;
				segundosColetor++;
			}
		};
		timerr.scheduleAtFixedRate(task, 1000, 1000);
		if (pacDecorado.velocidade == Nivel.vPacman) {
			this.velocidade = pacDecorado.velocidade + 1;
		}

	}

	@Override
	public void tick() {
		super.tick();

	}
}
