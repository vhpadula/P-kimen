package ClassesPersonagens;

import ClassesGerais.Controle;
import ClassesGerais.ID;

public abstract class FantasmaLaranja extends Fantasmas {

	public FantasmaLaranja(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma, int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.gaiola = true;
		this.geral = new MovimentacaoGeral(super.controle, this);
		this.scatter = new Scatter(super.controle, this, 0, 700);
		this.chase = new ChaseOrange(super.controle, this);
		this.pontosNecessarios = 600;
		this.comido = false;
		this.comestivel = false;
	}
}
