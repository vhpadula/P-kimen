import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Mapa {
	public int rows;
	public int cols;
	public char[][] map;
	Controle controle;

	public Mapa(boolean load, Controle ctrl) {
		this.controle=ctrl;
		if (load) {
			try {
				String mapPath = SetPath.setPath("maps\\classic.txt");
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
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	void fazParedes() throws IOException {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == '|') {
					controle.objetos.add(new Parede(j, i, "texturas\\wall.png", ID.Parede,this));
				}
			}
		}
	}

	void fazPastilhas() throws IOException {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == 'o') {
					controle.objetos.add(new Pastilha(j, i, "texturas\\pastilha.png", ID.Pastilha,this));
				}
			}
		}
	}
	
	void fazPacman() throws IOException {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == 'c') {
					controle.objetos.add(new Pacman(30*j, 21*i + 4, "chacacters\\pacman.png", ID.Pacman,this));
				}
			}
		}
	}
}
