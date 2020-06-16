package ClassesTabuleiro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import ClassesGerais.Fabrica;
import ClassesGerais.Controle;
import ClassesGerais.ID;
import ClassesGerais.Jogo;
import ClassesGerais.SetPath;
import ClassesInterface.ESTADO;

public class Mapa {
	public int rows;
	public int cols;
	public char[][] map;
	Controle controle;
	Jogo jogo;
	Fabrica fabrica;

	public Mapa(boolean load, Controle ctrl, Jogo jogo, Fabrica fabrica) {
		this.jogo = jogo;
		this.fabrica = fabrica;
		this.controle = ctrl;
		if (load) {
			try {
				String mapPath = SetPath.setPath("maps/classic.txt");
				BufferedReader buff = new BufferedReader(new FileReader(mapPath));
				String line = null;
				int i = 0;
				char[][] maps = new char[34][32];
				do {
					line = buff.readLine();
					if (line == null) {
						break;
					}
					char[] char_line = line.toCharArray();
					for (int j = 0; j < char_line.length; j++) {
						maps[i][j] = char_line[j];
					}
					i++;
				} while (line != null);
				map = maps;
				rows = maps.length;
				cols = maps[0].length;
				buff.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void constroiTabuleiro() throws IOException {
		if (jogo.estadoJogo == ESTADO.Jogo) {

			this.fazParedes();
			this.fazPortao();
			this.fazPastilhas();
			this.fazPacman();
			this.fazFantasma();
			this.fazCruzamentos();
			this.fazCerejas();
			this.fazPilulas();

		}
	}

	String identificaCruzamentos(int i, int j) {
		String cruzamento = "";
		if (map[i][j] == 'o' || map[i][j] == 'C' || map[i][j] == 'O' || map[i][j] == ' ') {
			if (i == 0) {
				if (map[i + 1][j] == 'o' || map[i + 1][j] == 'C' || map[i + 1][j] == 'O' || map[i + 1][j] == ' ' || map[i + 1][j] == 'v')
					cruzamento += "D";
			} else if (i == rows - 1) {
				if (map[i - 1][j] == 'o' || map[i - 1][j] == 'C' || map[i - 1][j] == 'O' || map[i - 1][j] == ' ' || map[i - 1][j] == 'v')
					cruzamento += "U";
			} else {
				if (map[i + 1][j] == 'o' || map[i + 1][j] == 'C' || map[i + 1][j] == 'O' || map[i + 1][j] == ' ' || map[i + 1][j] == 'v')
					cruzamento += "D";
				if (map[i - 1][j] == 'o' || map[i - 1][j] == 'C' || map[i - 1][j] == 'O' || map[i - 1][j] == ' ' || map[i - 1][j] == 'v')
					cruzamento += "U";
			}

			if (j == 0) {
				if (map[i][j + 1] == 'o' || map[i][j + 1] == 'C' || map[i][j + 1] == 'O' || map[i][j + 1] == ' ' || map[i][j + 1] == 'v')
					cruzamento += "R";
			} else if (j == cols - 1) {
				if (map[i][j - 1] == 'o' || map[i][j - 1] == 'C' || map[i][j - 1] == 'O' || map[i][j - 1] == ' ' || map[i][j - 1] == 'v')
					cruzamento += "L";
			} else {
				if (map[i][j + 1] == 'o' || map[i][j + 1] == 'C' || map[i][j + 1] == 'O' || map[i][j + 1] == ' ' || map[i][j + 1] == 'v')
					cruzamento += "R";
				if (map[i][j - 1] == 'o' || map[i][j - 1] == 'C' || map[i][j - 1] == 'O' || map[i][j - 1] == ' ' || map[i][j - 1] == 'v')
					cruzamento += "L";
			}
		}
		return cruzamento;
	}

	void fazParedes() throws IOException {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == '|') {

					fabrica.fazParedes(j, i);

				}
			}
		}
	}

	void fazPortao() throws IOException {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == '_') {

					fabrica.fazPortao(j, i);

				}
			}
		}
	}

	void fazPastilhas() throws IOException {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == 'o') {
					fabrica.fazPastilhas(j, i);

				}
			}
		}
	}
	
	void fazCerejas() throws IOException {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == 'C') {
					fabrica.fazCerejas(j, i);

				}
			}
		}
	}
	
	void fazPilulas() throws IOException {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == 'O') {
					fabrica.fazPilulas(j, i);
				}
			}
		}
	}

	void fazPacman() throws IOException {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == 'c') {
					fabrica.fazPacman(j, i);

				}
			}
		}
	}

	void fazFantasma() throws IOException {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				fabrica.fazFantasmas(j, i, map[i][j]);
			}
		}
	}

	void fazCruzamentos() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == 'o' || map[i][j] == 'C' || map[i][j] == 'O' || map[i][j] == ' ') {
					if (jogo.estadoJogo == ESTADO.Jogo) {
						String cruzamento = identificaCruzamentos(i, j);
						if ((cruzamento.contains("U") || cruzamento.contains("D"))
								&& (cruzamento.contains("L") || cruzamento.contains("R"))) {
							controle.objetos.add(new Cruzamento(j, i, ID.Cruzamento, controle, cruzamento));
						}
					}
				}
			}
		}
	}
}
