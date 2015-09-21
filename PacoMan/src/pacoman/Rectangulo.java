package pacoman;

public class Rectangulo {

	private Punto p1;
	private Punto p2;
	
	public Rectangulo(){
		p1  = new Punto();
		p2 = new Punto();
	}

	public Rectangulo(Punto x1, Punto x2){
		p1=x1;
		p2=x2;
	}
	
	public boolean contieneA(Punto p3) {
		return((p3.esMayorIgualEnXeYque(p1)) && (p3.esMenorIgualEnXeYque(p2)) ||
		       ((p3.esMayorIgualEnXeYque(p2)) && (p3.esMenorIgualEnXeYque(p1))));
	}

}
