
public class SetPath {
	
	public static String setPath(String imagePath) {
		String path;
		String sistemaOperacional = System.getProperty("os.name");
		if (sistemaOperacional.contains("Windows")) {
			path = "src/" + imagePath;
		} else {
			path = imagePath;
		}
		return path;
	}
}
