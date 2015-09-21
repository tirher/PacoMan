package pacoman;

public class Punto {
	
	private double x;
	private double y;
	
	public Punto(){
		//x=0.0;
		//y=0.0;
		this(0.0,0.0);
	}
	
	public Punto(double x, double y){
		this.x=x;
		this.y=y;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	public double distanciaCon(Punto p1){
		return (Math.sqrt(Math.pow((this.x-p1.x),2)+Math.pow((this.y-p1.y),2)));
	}
	
	public boolean esMenorIgualEnXeYque(Punto p2){
		return(this.x<=p2.x && this.y<=p2.y);
	}
	
	public boolean esMayorIgualEnXeYque(Punto p2){
		return(this.x>=p2.x && this.y>=p2.y);
	}

	public static void main(String[] args) {
	
	}

}
