package ClassesPersonagens;

import ClassesGerais.Controle;
import ClassesGerais.ID;

public abstract class FantasmaRosa extends Fantasmas {

	public FantasmaRosa(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma, int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.gaiola = true;
		this.chase = new ChasePink(super.controle, this);
		this.scatter = new Scatter(super.controle, this, 0, 0);
		this.geral = new MovimentacaoGeral(super.controle, this);
		this.pontosNecessarios = 0;
		this.comido = false;
		this.comestivel = false;
	}
}
