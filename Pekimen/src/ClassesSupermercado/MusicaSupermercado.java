package ClassesSupermercado;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import ClassesGerais.Musica;

public class MusicaSupermercado extends Musica {
	public MusicaSupermercado() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		super();

		this.pathLoop = "Supermercado/Supermercado.wav";
		this.tocaLoop();
	}
}
