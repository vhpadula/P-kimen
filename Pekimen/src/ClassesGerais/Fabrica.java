package ClassesGerais;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public abstract class Fabrica {
	Controle controle;
	Jogo jogo;
	public Fabrica(Controle controle, Jogo jogo) {
		this.controle = controle;
		this.jogo=jogo;
	}

	abstract public void fazParedes(int x, int y) throws IOException;

	abstract public void fazPortao(int x, int y) throws IOException;

	abstract public void fazPastilhas(int x, int y) throws IOException;
	
	abstract public void fazCerejas(int x, int y) throws IOException;
	
	abstract public void fazImas(int x,int y) throws IOException;
	
	abstract public void fazPilulas(int x, int y) throws IOException;

	abstract public void fazPacman(int x, int y) throws IOException;

	abstract public void fazFantasmas(int x, int y, char c) throws IOException;
	
	abstract public void atualizaFundo() throws IOException;
	
	abstract public void fazMusica() throws LineUnavailableException, IOException, UnsupportedAudioFileException;
	
}
