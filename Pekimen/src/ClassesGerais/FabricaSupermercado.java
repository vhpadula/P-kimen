package ClassesGerais;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import ClassesSupermercado.FantasmaAzulSupermercado;
import ClassesSupermercado.FantasmaLaranjaSupermercado;
import ClassesSupermercado.FantasmaRosaSupermercado;
import ClassesSupermercado.FantasmaVermelhoSupermercado;
import ClassesSupermercado.PacmanSupermercado;
import ClassesSupermercado.ParedeSupermercado;
import ClassesSupermercado.PastilhaSupermercado;
import ClassesSupermercado.PortaoSupermercado;

public class FabricaSupermercado extends Fabrica {

	public FabricaSupermercado(Controle controle,Jogo jogo) {
		super(controle,jogo);
	}

	@Override
	public void fazParedes(int x, int y) throws IOException {
		controle.objetos.add(new ParedeSupermercado(x, y, ID.Parede, controle, ""));
	}

	@Override
	public void fazPortao(int x, int y) throws IOException {
		controle.objetos.add(new PortaoSupermercado(x, y, ID.Parede, controle, "U"));
	}

	@Override
	public void fazPastilhas(int x, int y) throws IOException {
		controle.objetos.add(new PastilhaSupermercado(x, y, ID.Pastilha, controle, ""));
	}

	@Override
	public void fazPacman(int x, int y) {
		controle.objetos.add(new PacmanSupermercado(30 * x, 21 * y, ID.Pacman, controle, ""));

	}

	@Override
	public void fazFantasmas(int x, int y, char c) {
		if (c == 'a')
			controle.objetos.add(new FantasmaAzulSupermercado(30 * x + 4, 21 * y, ID.Fantasma, controle, "", 0, 1));
		if (c == 'v')
			controle.objetos.add(new FantasmaVermelhoSupermercado(30 * x + 4, 21 * y, ID.Fantasma, controle, "", 0, 0));
		if (c == 'l')
			controle.objetos.add(new FantasmaLaranjaSupermercado(30 * x + 4, 21 * y, ID.Fantasma, controle, "", 0, -1));
		if (c == 'r')
			controle.objetos.add(new FantasmaRosaSupermercado(30 * x + 4, 21 * y, ID.Fantasma, controle, "", 0, 0));
	}

	@Override
	public void atualizaFundo() throws IOException {
		jogo.janela.setImage("Supermercado/fundo.png");
		
	}

	@Override
	public void fazMusica() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		// TODO Auto-generated method stub
		
	}

}
