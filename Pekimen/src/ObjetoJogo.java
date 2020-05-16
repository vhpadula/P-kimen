import java.awt.Graphics;

public abstract class ObjetoJogo {
	protected int x,Vx;
	protected int y,Vy;
	
	
	ObjetoJogo(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
	
	public void setVx(int Vx) {
		this.Vx=Vx;
	}
	public void setVy(int Vy) {
		this.Vy=Vy;
	}
}
