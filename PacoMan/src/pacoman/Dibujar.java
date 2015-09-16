package pacoman;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import java.awt.Rectangle;
import java.awt.Color;

public class Dibujar extends JPanel implements ActionListener{
	
	private PacoMan pacoman;
	private Fantasma fantasma;
	private String fondo= "fondo.png";
	private Image imagenFondo;
	private Timer timer; //Maneja la velocidad del pacman
	
	
	public Dibujar(){
		setBackground(Color.WHITE); //Color de fondo black
		setFocusable(true); //Para que el teclado detecte el color
		addKeyListener(new teclado());
		
		pacoman = new PacoMan(360,250);
		fantasma = new Fantasma(100,100);
				
		timer = new Timer(5, this); //Le doy la velocidad al pacman, a los fantasmas le daré menos
		timer.start();				//cada 5 milisegundos se aplica un cambio en la aplicacion
	}
	
	public void paint(Graphics grafica){
		super.paint(grafica);
		
		Graphics2D g3 = (Graphics2D) grafica;
		
		/*
		ImageIcon img = new ImageIcon(this.getClass().getResource(fondo));
		imagen = img.loadImage(fondo);
		g3.drawImage(fondo);
		//Graphics2D g2 = (Graphics2D) grafica;
		 */
		g3.drawImage(fantasma.getImagen(), fantasma.getX(), fantasma.getY(), null);
		
		g3.drawImage(pacoman.getImagen(), pacoman.getX(), pacoman.getY(), null);
		
		
		
		
		/*Graphics2D g = (Graphics2D) grafica;
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("background.png"));
		g.drawImage(imagenFondo.getImage(),0,0,800,565, null);
		setOpaque(false);
		super.paintComponent(g);
		 */

		
	}
	
	//Es necesario ponerlo sino lanzará error. PacoMan todo el tiempo debe ejecutar el mover
	public void actionPerformed(ActionEvent e){
		pacoman.mover();
		repaint();	// Vuelve a dibujar la imagen en el tablero cada 5 mili-segundos
	}
	
	private class teclado extends KeyAdapter{
		
		public void keyReleased(KeyEvent e){
			pacoman.keyReleased(e);
		}
		
		public void keyPressed(KeyEvent e){
			pacoman.keyPressed(e);
		}
		
	}
}