import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Mapa{
	private int rows;
	private int cols;
	private char[][] map;
	ArrayList<Parede> paredes= new ArrayList<Parede>();
	ArrayList<Pastilha> pastilhas= new ArrayList<Pastilha>();
	public Mapa(boolean load) {
		if (load) {
			try {
				BufferedReader buff = new BufferedReader(new FileReader("src\\map.txt"));
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
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	void fazParedes() throws IOException {
		for (int i= 0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				if (map[i][j]== '|') {
					paredes.add(new Parede (j,i,"texturas\\terra.png", ID.Parede));
				}
			}
		}
	}
	
	
	void fazPastilhas() throws IOException {
		for (int i= 0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				if (map[i][j]== 'o') {
					pastilhas.add(new Pastilha (j,i,"texturas\\pastilha.png", ID.Pastilha));
				}
			}
		}
	}
}
