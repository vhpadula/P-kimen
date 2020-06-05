import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Mapa {
	public int rows;
	public int cols;
	public char[][] map;
	Controle controle;
	Jogo jogo;

	public Mapa(boolean load, Controle ctrl, Jogo jogo) {
		this.jogo = jogo;
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
				this.fazParedes();
				this.fazPastilhas();
				this.fazPacman();
				this.fazFantasma();
				this.fazCruzamentos();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	String identificaCruzamentos(int i, int j) {
		String cruzamento = "";
		if (map[i][j] == 'o' || map[i][j] == ' ') {
			if (i == 0) {
				if (map[i + 1][j] == 'o' || map[i + 1][j] == ' ')
					cruzamento += "D";
			} else if (i == rows - 1) {
				if (map[i - 1][j] == 'o' || map[i - 1][j] == ' ')
					cruzamento += "U";
			} else {
				if (map[i + 1][j] == 'o' || map[i + 1][j] == ' ')
					cruzamento += "D";
				if (map[i - 1][j] == 'o' || map[i - 1][j] == ' ')
					cruzamento += "U";
			}

			if (j == 0) {
				if (map[i][j + 1] == 'o' || map[i][j + 1] == ' ')
					cruzamento += "R";
			} else if (j == cols - 1) {
				if (map[i][j - 1] == 'o' || map[i][j - 1] == ' ')
					cruzamento += "L";
			} else {
				if (map[i][j + 1] == 'o' || map[i][j + 1] == ' ')
					cruzamento += "R";
				if (map[i][j - 1] == 'o' || map[i][j - 1] == ' ')
					cruzamento += "L";
			}
		}
		return cruzamento;
	}

	void fazParedes() throws IOException {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == '|') {
					if (jogo.estadoJogo == ESTADO.Jogo) {
						controle.objetos.add(new Parede(j, i, "texturas/wall.png", ID.Parede, this, controle, ""));
					}
				}
			}
		}
	}

	void fazPastilhas() throws IOException {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == 'o') {
					if (jogo.estadoJogo == ESTADO.Jogo) {
						controle.objetos
								.add(new Pastilha(j, i, "texturas/pastilha.png", ID.Pastilha, this, controle, ""));
					}
				}
			}
		}
	}

	void fazPacman() throws IOException {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == 'c') {
					if (jogo.estadoJogo == ESTADO.Jogo) {
						controle.objetos.add(new Pacman(30 * j, 21 * i, "characters/pacman_right.png", ID.Pacman, this,
								controle, ""));
					}
				}
			}
		}
	}

	void fazFantasma() throws IOException {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == 'a') {
					if (jogo.estadoJogo == ESTADO.Jogo) {
						controle.objetos.add(new FantasmaAzul(30 * j + 4, 21 * i, "characters/fantasmaAzul.png",
								ID.Fantasma, this, controle, ""));
					}
				} else if (map[i][j] == 'v') {
					if (jogo.estadoJogo == ESTADO.Jogo) {
						controle.objetos.add(new FantasmaVermelho(30 * j + 4, 21 * i, "characters/fantasmaVermelho.png",
								ID.Fantasma, this, controle, ""));
					}
				} else if (map[i][j] == 'l') {
					if (jogo.estadoJogo == ESTADO.Jogo) {
						controle.objetos.add(new FantasmaLaranja(30 * j + 4, 21 * i, "characters/fantasmaLaranja.png",
								ID.Fantasma, this, controle, ""));
					}
				} else if (map[i][j] == 'r') {
					if (jogo.estadoJogo == ESTADO.Jogo) {
						controle.objetos.add(new FantasmaRosa(30 * j + 4, 21 * i, "characters/fantasmaRosa.png",
								ID.Fantasma, this, controle, ""));
					}
				}
			}
		}
	}

	void fazCruzamentos() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == 'o' || map[i][j] == ' ') {
					if (jogo.estadoJogo == ESTADO.Jogo) {
						String cruzamento = identificaCruzamentos(i, j);
						if ((cruzamento.contains("U") || cruzamento.contains("D"))
								&& (cruzamento.contains("L") || cruzamento.contains("R"))) {
							controle.objetos.add(new Cruzamento(j, i, "", ID.Cruzamento, this,
									controle, cruzamento));
						}
					}
				}
			}
		}
	}
}
