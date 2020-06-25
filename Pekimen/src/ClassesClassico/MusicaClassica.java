package ClassesClassico;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import ClassesGerais.Musica;

public class MusicaClassica extends Musica {

	public MusicaClassica() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		super();
		this.pathLoop= "src/Classic/loopClassico.wav";
		this.tocaLoop();
	}
}
