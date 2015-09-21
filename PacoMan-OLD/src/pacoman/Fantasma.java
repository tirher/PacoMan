package pacoman;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;

public class Fantasma {

	//private String pacoman = "01_derAbierta.png";
	private String fantasma = "fantasma.gif";

	private int dx;
	private int dy;
	private int x;
	private int y;

	private Image imagen;
	
	public Fantasma(int x, int y) {
		this.x=x;
		this.y=y;
		
		//Busca la imagen para mostrar por pantalla (por default a la derecha)
		ImageIcon img = new ImageIcon(this.getClass().getResource(fantasma));
		imagen = img.getImage();
	
	}

	public void mover() {
		//x e y definen donde se posiciona la imagen
		x += dx;
		y += dy;
	}
	
	//Getters
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Image getImagen(){
		return imagen;
	}

	//Setter
	public void setImagen(String fantasma){
		this.fantasma =""+fantasma;
	}
	
	//Si presiono la tecla correspondiente muevo en un valor en cierta direccion
	public void keyPressed(KeyEvent e) {
		
		int tecla = e.getKeyCode();
		
		if (tecla == KeyEvent.VK_A) { //Si toco la flecha <- resta 1 en x
			rotarImagenIzquierda();
			if(getX()>0)
				dx = -1;
			else
				dx = 0;	//Evita que salga de la pantalla
		}
		if (tecla == KeyEvent.VK_S) { //Si toco la flecha -> suma 1 en x
			rotarImagenDerecha();
			if(getX()<=750)
				dx = +1;
			else
				dx = 0;
		}
		if (tecla == KeyEvent.VK_W) { //Si sube disminuyo en y
			rotarImagenArriba();
			if(getY()>0)
				dy = -1;
			else
				dy = 0;
		}
		if (tecla == KeyEvent.VK_Z) { //Si baja aumenta en y
			rotarImagenAbajo();
			if(getY()<=523)
				dy = +1;
			else
				dy = 0;
		}
	}

	//Si dejo de presionas detengo el movimiento
	public void keyReleased(KeyEvent e) {

		int tecla = e.getKeyCode();

		if (tecla == KeyEvent.VK_A) {
			dx = 0;
		}
		if (tecla == KeyEvent.VK_S) {
			dx = 0;
		}
		if (tecla == KeyEvent.VK_W) {
			dy = 0;
		}
		if (tecla == KeyEvent.VK_Z) {
			dy = 0;
		}
	}
	
	//Rotación de imagenes
	public void rotarImagenIzquierda() {
		//setImagen("01_izqAbierta.png");
		//setImagen("izquierda.gif");
		ImageIcon img = new ImageIcon(this.getClass().getResource(fantasma));
		imagen = img.getImage();
	}

	public void rotarImagenDerecha() {
		//setImagen("01_derAbierta.png");
		//setImagen("derecha.gif");
		ImageIcon img = new ImageIcon(this.getClass().getResource(fantasma));
		imagen = img.getImage();
	}
	
	public void rotarImagenArriba() {
		//setImagen("01_upAbierta.png");
		//setImagen("up.gif");
		ImageIcon img = new ImageIcon(this.getClass().getResource(fantasma));
		imagen = img.getImage();
	}
	
	public void rotarImagenAbajo() {
		//setImagen("01_downAbierta.png");
		//setImagen("down.gif");
		ImageIcon img = new ImageIcon(this.getClass().getResource(fantasma));
		imagen = img.getImage();
	}
	
}
