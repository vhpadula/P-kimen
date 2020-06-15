package ClassesSelva;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import ClassesGerais.Musica;

public class MusicaSelva extends Musica {
	public MusicaSelva() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		super();
		
		this.pathLoop= "src/Selva/loopSelva.wav";
		this.tocaLoop();
		
	}
}
