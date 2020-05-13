
public class Musica {
	String titulo;
	String album; 
	String compositor;
	int ano;
	int tamanhoBytes = 0;
	
	Musica(String titulo, String album, String compositor, int ano){
		this.titulo = titulo;
		this.album = album;
		this.compositor = compositor;
		this.ano = ano;
	}
	
	void imprimeMusica() {
		System.out.println(titulo + " " + album +" "+ compositor + " " + ano);
	}
	
	int getTamanhoBytes() {
		return tamanhoBytes;
	}
	
	void setTamanhoBytes(int tamanhoBytes) {
		this.tamanhoBytes = tamanhoBytes;
	}
}
