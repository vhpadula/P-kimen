import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class ObjetoJogo {
	protected int x, Vx;
	protected int y, Vy;
	protected int valorVAnterior = 0;
	protected ID id;
	protected String vAnterior = null;
	Mapa mapa;
	Controle controle;
	protected BufferedImage textura;

	ObjetoJogo(int x, int y, String imagePath, ID id, Mapa mapa, Controle controle) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.mapa = mapa;
		this.controle = controle;
		imagePath = SetPath.setPath(imagePath);
		try {
			this.textura = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public abstract Rectangle getBounds();

	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public void setVx(int Vx) {
		this.Vx = Vx;
	}

	public void setVy(int Vy) {
		this.Vy = Vy;
	}

	public void setVAnterior(){
		boolean vHorizontal = false, vVertical = false;
		if(Vx != 0){
			vHorizontal = true;
		}
		else if(Vy != 0){
			vVertical = true;
		}

		if(vHorizontal){
			vAnterior = "H";
			valorVAnterior = Vx;
		}
		else if(vVertical){
			vAnterior = "V";
			valorVAnterior = Vy;
		}
		else{
			vAnterior = null;
		}
	}
	
	public ID getID() {
		return this.id;
	}
	
	public void setImage(String imagePath) {
		imagePath = SetPath.setPath(imagePath);
		try {
			this.textura = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
