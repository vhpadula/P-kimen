
public class MusicaMP3 extends Musica{
	
	MusicaMP3(String titulo, String album, String compositor, int ano, int tamanhoBytes){
		super(titulo, album, compositor, ano);
		this.setTamanhoBytes(tamanhoBytes);
	}

	void imprimeMusica() {
		System.out.println(titulo + " " + album +" "+ compositor + " " + ano + " " + getTamanhoBytes() + "B");
	}
}
