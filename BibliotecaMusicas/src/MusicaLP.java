
public class MusicaLP extends Musica {
	private int velocidadeRPM;
	
	MusicaLP(String titulo, String album, String compositor, int ano, int velocidadeRPM){
		super(titulo, album, compositor, ano);
		this.velocidadeRPM = velocidadeRPM;
	}
	
	void imprimeMusica() {
		System.out.println(titulo + " " + album +" "+ compositor + " " + ano + " "+ velocidadeRPM + "RPM");
	}
}
