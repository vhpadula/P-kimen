package ClassesPersonagens;
import java.util.Random;

public class MovimentacaoAleatoria implements MovimentacaoFantasma {
	
	Fantasmas fantasma;
	
	public MovimentacaoAleatoria(Fantasmas fantasma) {
		this.fantasma = fantasma;
	}
	
	@Override
	public void movimentar() {
		int determinaVel = 0;
		Random r = new Random();
		fantasma.setVx(1);
	}

}
