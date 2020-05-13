import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BibliotecaTest {

	@Test
	void testeTitulo() {
		long tempoInicial = System.currentTimeMillis();
		MusicaLP tangerine = new MusicaLP("Tangerine", "Led Zeppelin III","Led Zeppelin", 1970, 45);
		MusicaLP time = new MusicaLP("Time","The Dark Side of The Moon", "Pink Floyd", 1973, 45);
		MusicaLP getBack = new MusicaLP("Get Back", "Let It Be", "Beatles", 1970, 45);
		
		Musica[] musicas = {tangerine, time, getBack};
		Biblioteca biblioteca = new Biblioteca (musicas);
		Musica[] listaMusicas = biblioteca.procuraMusicasTitulo("a");
		assertEquals(listaMusicas[0], tangerine);
		assertEquals(listaMusicas[1], getBack);
		long tempoFinal = System.currentTimeMillis();
		System.out.println("Executado em = " + (tempoFinal - tempoInicial) + "ms");
	}

}
