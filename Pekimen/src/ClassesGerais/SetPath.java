package ClassesGerais;

public class SetPath {

	public static String setPath(String imagePath) {
		String path;
		String sistemaOperacional = System.getProperty("os.name");
		if (sistemaOperacional.contains("mac")) {
			path = imagePath;
		} else {
			path = "src/" + imagePath;
		}
		return path;
	}
}
