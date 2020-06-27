package ClassesGerais;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Musica {

	public String pathLoop;
	public Clip clipLoop;
	public void fazBarulho(String path) throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		
		Clip clip;
		File f = new File(ClassesGerais.SetPath.setPath(path));

		AudioInputStream som = AudioSystem.getAudioInputStream(f.getAbsoluteFile());
		clip = AudioSystem.getClip();
		clip.start();
		clip.open(som);
		clip.setFramePosition(0);
		clip.start();
	}

	public void tocaLoop() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		File f = new File(ClassesGerais.SetPath.setPath(pathLoop));

		AudioInputStream loop = AudioSystem.getAudioInputStream(f.getAbsoluteFile());
		clipLoop = AudioSystem.getClip();
		clipLoop.start();
		clipLoop.open(loop);
		clipLoop.setFramePosition(0);
		clipLoop.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void para() {
		clipLoop.stop();
	}
}
