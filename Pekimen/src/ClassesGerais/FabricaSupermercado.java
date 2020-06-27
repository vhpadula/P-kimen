package ClassesGerais;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import ClassesClassico.ImaClassico;
import ClassesSupermercado.CerejaSupermercado;
import ClassesSupermercado.FantasmaAzulSupermercado;
import ClassesSupermercado.FantasmaLaranjaSupermercado;
import ClassesSupermercado.FantasmaRosaSupermercado;
import ClassesSupermercado.FantasmaVermelhoSupermercado;
import ClassesSupermercado.MusicaSupermercado;
import ClassesSupermercado.PacmanSupermercado;
import ClassesSupermercado.ParedeSupermercado;
import ClassesSupermercado.PastilhaSupermercado;
import ClassesSupermercado.PilulaSupermercado;
import ClassesSupermercado.PortaoSupermercado;
import Niveis.Nivel;

public class FabricaSupermercado extends Fabrica {

	public FabricaSupermercado(Controle controle, Jogo jogo) {
		super(controle, jogo);
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
	public void fazCerejas(int x, int y) throws IOException {
		controle.objetos.add(new CerejaSupermercado(x, y, ID.Cereja, controle, ""));
	}

	@Override
	public void fazPilulas(int x, int y) throws IOException {
		controle.objetos.add(new PilulaSupermercado(x, y, ID.Pilula, controle, ""));
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

	public void fazFantasmaAzul(int x, int y, char c, int i) {
		if (c == 'a') {
			controle.objetos.set(i, new FantasmaAzulSupermercado(x, y, ID.Fantasma, controle, "", 0, 1));
			controle.objetos.get(i).velocidade = Nivel.vFantasma;
		}
	}

	public void fazFantasmaVermelho(int x, int y, char c, int i) {
		if (c == 'v') {
			controle.objetos.set(i, new FantasmaVermelhoSupermercado(x, y, ID.Fantasma, controle, "", 0, 1));
			controle.objetos.get(i).velocidade = Nivel.vFantasma;
		}
	}

	public void fazFantasmaLaranja(int x, int y, char c, int i) {
		if (c == 'l') {
			controle.objetos.set(i, new FantasmaLaranjaSupermercado(x, y, ID.Fantasma, controle, "", 0, 1));
			controle.objetos.get(i).velocidade = Nivel.vFantasma;
		}
	}

	public void fazFantasmaRosa(int x, int y, char c, int i) {
		if (c == 'r') {
			controle.objetos.set(i, new FantasmaRosaSupermercado(x, y, ID.Fantasma, controle, "", 0, 1));
			controle.objetos.get(i).velocidade = Nivel.vFantasma;
		}
	}

	@Override
	public void atualizaFundo() throws IOException {
		jogo.janela.setImage("Supermercado/supermercadofundopixel.png");
	}

	@Override
	public void fazMusica() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		jogo.musica=new MusicaSupermercado();
	}

	@Override
	public void fazImas(int x, int y) throws IOException {
		controle.objetos.add(new ImaClassico(x, y, ID.Ima, controle, ""));
	}
}
