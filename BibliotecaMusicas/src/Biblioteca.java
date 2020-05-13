
public class Biblioteca {
	Musica[] musicas;
	//Teste mocificacao
	Biblioteca(Musica[] musicas){
		this.musicas = musicas;
	}
	
	public static void main(String args[]) {
		MusicaLP tangerine = new MusicaLP("Tangerine", "Led Zeppelin III","Led Zeppelin", 1970, 45);
		MusicaLP time = new MusicaLP("Time","The Dark Side of The Moon", "Pink Floyd", 1973, 45);
		MusicaLP getBack = new MusicaLP("Get Back", "Let It Be", "Beatles", 1970, 45);
		
		MusicaCD detento = new MusicaCD("Diario de Um Detento", "Sobrevivendo ao Inferno", "Racionais", 1997);
		MusicaCD tissue = new MusicaCD("Scar Tissue", "Californication", "Red Hot Chilli Peppers", 1999);
		MusicaCD lithium = new MusicaCD("Lithium", "Nevermind", "Nirvana", 1991);
		
		MusicaMP3 walk = new MusicaMP3("Walk", "Wasting Light", "Foo Fighters", 2011, 250000);
		MusicaMP3 amarelo = new MusicaMP3("AmarElo", "AmarElo", "Emicida", 2019, 300000);
		MusicaMP3 cocaina = new MusicaMP3("Cocaina", "Rap e Compromisso (Comemorativo)", "Sabotage", 2014, 200000);
		MusicaMP3 hysteria = new MusicaMP3("Hysteria", "Absolution", "Muse", 2004, 400000);
		
		Musica[] musicas = {tangerine, time, getBack, detento, tissue, lithium, walk, amarelo, cocaina, hysteria};
		Biblioteca biblioteca = new Biblioteca(musicas);
		biblioteca.procuraMusicas(2000, 2019);
	}
	
	void imprimeBiblioteca() {
		for(Musica musica: musicas) {
			musica.imprimeMusica();
		}
	}
	
	Musica[] procuraArquivosGrandes(int Bytes) {
		Musica[] listaMusicas = new Musica[10];
		int i = 0;
		for (Musica musica: musicas) {
			if(musica.getTamanhoBytes() > Bytes) {
				listaMusicas[i++] = musica;
				musica.imprimeMusica();
			}
		}
		return listaMusicas;
	}
	
	Musica[] procuraMusicas(int anoInicio, int anoFim) {
		Musica[] listaMusicas = new Musica[10];
		int i = 0;
		for(Musica musica: musicas) {
			if(musica.ano >= anoInicio && musica.ano <= anoFim) {
				listaMusicas[i++] = musica;
				musica.imprimeMusica();
			}
		}
		return listaMusicas;
	}
	
	Musica[] procuraMusicasTitulo(String titulo) {
		Musica [] listaMusicas = new Musica[10];
		int i = 0;
		for(Musica musica: musicas) {
			if(musica.titulo.contains(titulo)) {
				listaMusicas[i++] = musica;
				musica.imprimeMusica();
			}
		}
		return listaMusicas;
	}
	
	Musica[] procuraMusicaCompositor(String compositor) {
		Musica[] listaMusicas = new Musica[10];
		int i = 0;
		for(Musica musica: musicas) {
			if(musica.compositor.contains(compositor)) {
				listaMusicas[i++] = musica;
				musica.imprimeMusica();
			}
		}
		return listaMusicas;
	}
	
	Musica[] procuraMusicaAlbum(String album) {
		Musica[] listaMusicas = new Musica[10];
		int i= 0;
		for(Musica musica: musicas) {
			if(musica.album.contains(album)) {
				listaMusicas[i++] = musica;
				musica.imprimeMusica();
			}
		}
		return listaMusicas;
	}
	
	Musica[] procuraMusica(String nome) {
		Musica[] listaMusicas = new Musica[10];
		int i = 0;
		for(Musica musica: musicas) {
			if(musica.titulo.contains(nome) || musica.album.contains(nome)|| musica.compositor.contains(nome)) {
				listaMusicas[i++] = musica;
				musica.imprimeMusica();
			}
		}
		return listaMusicas;
	}
}
