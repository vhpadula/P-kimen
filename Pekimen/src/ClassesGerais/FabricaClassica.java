package ClassesGerais;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import ClassesClassico.CerejaClassico;
import ClassesClassico.FantasmaAzulClassico;
import ClassesClassico.FantasmaLaranjaClassico;
import ClassesClassico.FantasmaRosaClassico;
import ClassesClassico.FantasmaVermelhoClassico;
import ClassesClassico.ImaClassico;
import ClassesClassico.MusicaClassica;
import ClassesClassico.PacmanClassico;
import ClassesClassico.ParedeClassica;
import ClassesClassico.PastilhaClassica;
import ClassesClassico.PilulaClassica;
import ClassesClassico.PortaoClassico;
import Niveis.Nivel;

public class FabricaClassica extends Fabrica {

	public FabricaClassica(Controle controle, Jogo jogo) {
		super(controle, jogo);

	}

	@Override
	public void fazParedes(int x, int y) throws IOException {
		controle.objetos.add(new ParedeClassica(x, y, ID.Parede, controle, ""));
	}

	@Override
	public void fazPortao(int x, int y) throws IOException {
		controle.objetos.add(new PortaoClassico(x, y, ID.Parede, controle, "U"));
	}

	@Override
	public void fazPastilhas(int x, int y) throws IOException {
		controle.objetos.add(new PastilhaClassica(x, y, ID.Pastilha, controle, ""));
	}
	
	@Override
	public void fazCerejas(int x, int y) throws IOException {
		controle.objetos.add(new CerejaClassico(x, y, ID.Cereja, controle, ""));
	}
	
	@Override
	public void fazPilulas(int x, int y) throws IOException {
		controle.objetos.add(new PilulaClassica(x, y, ID.Pilula, controle, ""));
	}

	@Override
	public void fazPacman(int x, int y) {
		controle.objetos.add(new PacmanClassico(30 * x, 21 * y, ID.Pacman, controle, ""));

	}

	@Override
	public void fazFantasmas(int x, int y, char c) {
		if (c == 'a') 
			controle.objetos.add(new FantasmaAzulClassico(30 * x + 4, 21 * y, ID.Fantasma, controle, "", 0, 1));
		if (c == 'v') 
			controle.objetos.add(new FantasmaVermelhoClassico(30 * x + 4, 21 * y, ID.Fantasma, controle, "", 0, 0));
		if (c == 'l') 
			controle.objetos.add(new FantasmaLaranjaClassico(30 * x + 4, 21 * y, ID.Fantasma, controle, "", 0, -1));
		if (c == 'r') 
			controle.objetos.add(new FantasmaRosaClassico(30 * x + 4, 21 * y, ID.Fantasma, controle, "", 0, 0));
	}
	
	public void fazFantasmaAzul (int x, int y, char c, int i ) {
		if (c == 'a') {
			controle.objetos.set(i,new FantasmaAzulClassico(x, y, ID.Fantasma, controle, "", 0, 1));
			controle.objetos.get(i).velocidade = Nivel.vFantasma;
		}
	}
	
	public void fazFantasmaVermelho (int x, int y, char c, int i) {
		if (c == 'v') {
			controle.objetos.set(i,new FantasmaVermelhoClassico(x ,  y, ID.Fantasma, controle, "", 0, 1));
			controle.objetos.get(i).velocidade = Nivel.vFantasma;
		}
	}
	
	public void fazFantasmaLaranja (int x, int y, char c, int i) {
		if (c == 'l') {
			controle.objetos.set(i,new FantasmaLaranjaClassico( x,  y, ID.Fantasma, controle, "", 0, 1));
			controle.objetos.get(i).velocidade = Nivel.vFantasma;
		}
	}
	
	public void fazFantasmaRosa (int x, int y, char c, int i) {
		if (c == 'r') {
			controle.objetos.set(i,new FantasmaRosaClassico( x, y, ID.Fantasma, controle, "", 0, 1));
			controle.objetos.get(i).velocidade = Nivel.vFantasma;
		}
	}
	
	
	@Override
	public void atualizaFundo() throws IOException  {
		jogo.janela.setImage("Classic/fundo.png");
		
	}

	@Override
	public void fazMusica() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		jogo.musica = new MusicaClassica();
		
	}

	@Override
	public void fazImas(int x, int y) throws IOException {
		controle.objetos.add(new ImaClassico(x,y,ID.Ima, controle, "" ));
		
	}
}
