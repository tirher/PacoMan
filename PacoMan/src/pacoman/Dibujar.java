package pacoman;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

import java.awt.Rectangle;
import java.awt.Color;

public class Dibujar extends JPanel implements ActionListener{
	
	private PacoMan pacoman;
	private Fantasma fantasma, fantasma1;
	private String fondo= "fondo.png";
	private Image imagenFondo;
	private Timer timer; //Maneja la velocidad del pacman
	
	
	public Dibujar(){
		setBackground(Color.WHITE); //Color de fondo black
		setFocusable(true); //Para que el teclado detecte el color
		addKeyListener(new teclado());
		
		pacoman = new PacoMan(360,250);
		fantasma = new Fantasma(100,100);	
		fantasma1 = new Fantasma(200,200);
		
		timer = new Timer(5, this); //Le doy la velocidad al pacman, a los fantasmas le daré menos
		timer.start();				//cada 5 milisegundos se aplica un cambio en la aplicacion
	}
	
	public void paint(Graphics grafica){
		super.paint(grafica);
		
		Graphics2D g3 = (Graphics2D) grafica;
		
		g3.drawImage(fantasma.getImagen(), fantasma.getX(), fantasma.getY(), null);
		
		g3.drawImage(fantasma1.getImagen(), fantasma1.getX(), fantasma1.getY(), null);
		
		g3.drawImage(pacoman.getImagen(), pacoman.getX(), pacoman.getY(), null);
		
		//System.out.println(pacoman.getX()+" "+pacoman.getY());
		//System.out.println(fantasma.getX()+" "+fantasma.getY());
		
		
		Punto ptoPac1 = new Punto(pacoman.getX()+25,pacoman.getY()+25);
		Punto ptoPac2 = new Punto(pacoman.getX()-25,pacoman.getY()-25);
		Punto ptoFan1 = new Punto(fantasma.getX()+25,fantasma.getY()+25);
		Punto ptoFan2 = new Punto(fantasma.getX()-25,fantasma.getY()-25);
		
		
		Rectangulo rectPac = new Rectangulo(ptoPac1,ptoPac2);
		Rectangulo rectFan = new Rectangulo(ptoFan1,ptoFan2);
		
		if(rectPac.contieneA(ptoFan1)){
			pacoman.setX(360);	
			pacoman.setY(250);
		}
		
		/*
		g3.draw(new Rectangle2D.Double(10, 20, 30, 40));
		
        RoundRectangle2D example = new RoundRectangle2D.Double(400,400,150,150,30,30);
        g3.setStroke(new BasicStroke(3f));
        g3.setPaint(Color.RED);
		Image img = Toolkit.getDefaultToolkit().getImage("01_derAbierta.png");
		setBackground(Color.BLACK);
		g3.drawImage(img,0,0, null); // image
		g3.draw(example);
			*/
				
		//Rectangulo rectanguloPac = new Rectangulo(pacoman.getX(),pacoman.getY());

		//g3.drawImage(pacoman.getImagen(),p1.getX(), p1.getY(), p2.getX(), p2.getY());
	}
	
	//Es necesario ponerlo sino lanzará error. PacoMan todo el tiempo debe ejecutar el mover
	public void actionPerformed(ActionEvent e){
		pacoman.mover();
		fantasma.mover();
		repaint();	// Vuelve a dibujar la imagen en el tablero cada 5 mili-segundos
	}
	
	private class teclado extends KeyAdapter{
		
		public void keyReleased(KeyEvent e){
			pacoman.keyReleased(e);
			fantasma.keyReleased(e);
		}
		
		public void keyPressed(KeyEvent e){
			pacoman.keyPressed(e);
			fantasma.keyPressed(e);
		}
		
	}
}