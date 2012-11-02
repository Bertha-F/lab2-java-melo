import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Conductor{
	private Auto a;

	public Conductor(){
		a = new Auto();
	}

	public static String leer(String mensaje){
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(mensaje);
		String c = "";
		try{ c = b.readLine(); }catch (Exception e) { System.out.print("Error: " + e.getMessage()); }
		return c;
	}

	public void menu(){
		String opcion = "";
		for(;;){
			a.mostrarEstado();
			System.out.println(" ---------------------------CONTROLES*--------------------------- ");
			System.out.println("| [E] encender  [A] acelerar  [F] frenar  [C] cambio  [O] apagar |");
			System.out.print(" ---------------------------------------------------- Opcion -> ");
			opcion = leer("");
			switch (opcion.toUpperCase()) {
				case "E":
					a.encender();
					break;
				case "A":
					if(a.encendido().equals("Encendido")){
						a.acelerar();	
					}else{
						System.out.println("Primero tiene que encender el auto.");
					}
					break;
				case "F":
					if(a.encendido().equals("Encendido")){
						a.frenar();
					}else{
						System.out.println("Primero tiene que encender el auto.");
					}
					break;
				case "C":
					if(a.encendido().equals("Encendido")){
						a.hacerCambio();
					}else{
						System.out.println("Primero tiene que encender el auto.");
					}
					break;
				case "O":
					a.apagar();
					a.mostrarEstado();
					if(a.salirAuto()){
						System.exit(0);	
					}
			}
		}
	}

	public static void main(String[] args){
		Conductor c = new Conductor();
		c.menu();
	}
}