package ClassesPersonagens;

import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesInterface.HUD;

public abstract class FantasmaAzul extends Fantasmas {
	
	public FantasmaAzul(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma, int VyFantasma) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma);
		this.gaiola=true;
		this.chase = new ChaseBlue(super.controle, this);
		this.scatter = new Scatter(super.controle, this, 700, 700);
		this.geral = new MovimentacaoGeral(super.controle, this);
		this.pontosNecessarios=300;
		this.comido=false;
		this.comestivel=false;
	}
	
	

	
}
