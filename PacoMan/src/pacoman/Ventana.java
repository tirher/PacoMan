package pacoman;

import java.awt.Color;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame{

	public Image imagenFondo;
	public URL fondo;
	
	public Ventana(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		add(new Dibujar());
		
		setTitle("PacoMan");							
		setSize(800,600);	
		setVisible(true);
		setLocationRelativeTo(null);//Centra la ventana
		setResizable(false); //Bloqueo de redimension de ventana
		
	}
	
	public static void main(String[] args){
		new Ventana();	
	}

}
