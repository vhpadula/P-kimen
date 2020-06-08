package ClassesGerais;

import java.io.IOException;


import ClassesSelva.FantasmaAzulSelva;
import ClassesSelva.FantasmaLaranjaSelva;
import ClassesSelva.FantasmaRosaSelva;
import ClassesSelva.FantasmaVermelhoSelva;
import ClassesSelva.PacmanSelva;
import ClassesSelva.ParedeSelva;
import ClassesSelva.PastilhaSelva;
import ClassesSelva.PortaoSelva;

public class FabricaSelva extends Fabrica {

	public FabricaSelva(Controle controle, Jogo jogo) {
		super(controle, jogo);
		
	}

	@Override
	public void fazParedes(int x, int y) throws IOException {
		controle.objetos.add(new ParedeSelva(x, y, ID.Parede, controle, ""));
	}

	@Override
	public void fazPortao(int x, int y) throws IOException {
		controle.objetos.add(new PortaoSelva(x, y, ID.Parede, controle, "U"));
	}

	@Override
	public void fazPastilhas(int x, int y) throws IOException {
		controle.objetos.add(new PastilhaSelva(x, y, ID.Pastilha, controle, ""));
	}

	@Override
	public void fazPacman(int x, int y) {
		controle.objetos.add(new PacmanSelva(30 * x, 21 * y, ID.Pacman, controle, ""));

	}

	@Override
	public void fazFantasmas(int x, int y, char c) {
		if (c == 'a')
			controle.objetos.add(new FantasmaAzulSelva(30 * x + 4, 21 * y, ID.Fantasma, controle, "", 0, 1));
		if (c == 'v')
			controle.objetos.add(new FantasmaVermelhoSelva(30 * x + 4, 21 * y, ID.Fantasma, controle, "", 0, 0));
		if (c == 'l')
			controle.objetos.add(new FantasmaLaranjaSelva(30 * x + 4, 21 * y, ID.Fantasma, controle, "", 0, -1));
		if (c == 'r')
			controle.objetos.add(new FantasmaRosaSelva(30 * x + 4, 21 * y, ID.Fantasma, controle, "", 0, 0));
	}

	@Override
	public void atualizaFundo() throws IOException  {
		jogo.janela.setImage("Selva/selva.png");
		
	}

}
