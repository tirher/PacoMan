package pacoman;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import java.awt.event.KeyEvent;

public class PacoMan {

	//private String pacoman = "01_derAbierta.png";
	private String pacoman = "derecha.gif";

	private int dx;
	private int dy;
	private int x;
	private int y;

	private Image imagen;
	
	public PacoMan(int x, int y) {
		this.x=x;
		this.y=y;
		
		//Busca la imagen para mostrar por pantalla (por default a la derecha)
		ImageIcon img = new ImageIcon(this.getClass().getResource(pacoman));
		imagen = img.getImage();
	
	}
	
	public Rectangle getBounds(Fantasma f){
		//return new Rectangle(x,Y,WIDH,HEIGHT)
		return new Rectangle(x,f.getY(),60,10);
	}

	public void mover() {
		//x e y definen donde se posiciona la imagen
		//x += dx;
		if(x + dx < 0)
			dx = 0;
		if(x + dx > 744)
			dx = 0;
		if(y + dy < 0)
			dy = 0;
		if(y + dy > 580)
			dy = 0;
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
	public void setImagen(String pacoman){
		this.pacoman =""+pacoman;
	}
	
	//Si presiono la tecla correspondiente muevo en un valor en cierta direccion
	public void keyPressed(KeyEvent e) {
		
		int tecla = e.getKeyCode();
		
		if (tecla == KeyEvent.VK_LEFT) { //Si toco la flecha <- resta 1 en x
			rotarImagenIzquierda();
			if(getX()>0)
				dx = -1;
			else
				dx = 0;	//Evita que salga de la pantalla
		}
		if (tecla == KeyEvent.VK_RIGHT) { //Si toco la flecha -> suma 1 en x
			rotarImagenDerecha();
			if(getX()<=750)
				dx = +1;
			else
				dx = 0;
		}
		if (tecla == KeyEvent.VK_UP) { //Si sube disminuyo en y
			rotarImagenArriba();
			if(getY()>0)
				dy = -1;
			else
				dy = 0;
		}
		if (tecla == KeyEvent.VK_DOWN) { //Si baja aumenta en y
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

		if (tecla == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		if (tecla == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
		if (tecla == KeyEvent.VK_UP) {
			dy = 0;
		}
		if (tecla == KeyEvent.VK_DOWN) {
			dy = 0;
		}
	}
	
	//Rotación de imagenes
	public void rotarImagenIzquierda() {
		//setImagen("01_izqAbierta.png");
		setImagen("izquierda.gif");
		ImageIcon img = new ImageIcon(this.getClass().getResource(pacoman));
		imagen = img.getImage();
	}

	public void rotarImagenDerecha() {
		//setImagen("01_derAbierta.png");
		setImagen("derecha.gif");
		ImageIcon img = new ImageIcon(this.getClass().getResource(pacoman));
		imagen = img.getImage();
	}
	
	public void rotarImagenArriba() {
		//setImagen("01_upAbierta.png");
		setImagen("up.gif");
		ImageIcon img = new ImageIcon(this.getClass().getResource(pacoman));
		imagen = img.getImage();
	}
	
	public void rotarImagenAbajo() {
		//setImagen("01_downAbierta.png");
		setImagen("down.gif");
		ImageIcon img = new ImageIcon(this.getClass().getResource(pacoman));
		imagen = img.getImage();
	}
	
}
