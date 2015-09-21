package pacoman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Dibujar extends JPanel implements ActionListener{
	
	private PacoMan pacoman;
	private Timer timer; //Maneja la velocidad del pacman
	
	
	public Dibujar(){
		setBackground(Color.WHITE); //Color de fondo black
		setFocusable(true); //Para que el teclado detecte el color
		addKeyListener(new teclado());
		
		pacoman = new PacoMan();
		timer = new Timer(5, this); //Le doy la velocidad al pacman, a los fantasmas le daré menos
		timer.start();				//cada 5 milisegundos se aplica un cambio en la aplicacion
	}
	
	public void paint(Graphics grafica){
		super.paint(grafica);
		
		Graphics2D g2 = (Graphics2D) grafica;
		g2.drawImage(pacoman.getImagen(), pacoman.getX(), pacoman.getY(), null);
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