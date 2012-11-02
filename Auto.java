public class Auto{
	private boolean encendido; // por defecto es false, apagado.
	private double velocidad; // por defecto se inicializa en 0.0
	private CajaDeCambio cajaDeCambio;
	private double aceleracion;
	private double frenado; // en cuanto desacelera cada vez que "presiona" el freno.

	public Auto(){
		cajaDeCambio = new CajaDeCambio();
	}

	public void acelerar(){
		double aumentoVelocidad = Double.parseDouble(Conductor.leer("En cuanto desea acelerar?\n-> "));
		if(cajaDeCambio.getCambio() != 0){
			setFrenado(0);
			aceleracion += aumentoVelocidad;
			velocidad += aceleracion;
			sistemaInteligente();	
		}else{
			System.out.println("Para \"andar\" primero debe realizar algun cambio.");
		}
	}

	public void frenar(){ // Cuando se "pisa" el freno se deja de acelerar y empieza a desacelerar
		double disminuirVelocidad = Double.parseDouble(Conductor.leer("En cuanto desea frenar?\n-> "));
		if(cajaDeCambio.getCambio() != 0){
			setFrenado(disminuirVelocidad);
			aceleracion = 0;
			velocidad -= disminuirVelocidad;
			sistemaInteligente();	
		}else{
			System.out.println("El carro no esta en movimiento.");
		}
		
	}

	public void setFrenado(double frenarEn){
		frenado = frenarEn;
	}

	public double getFrenado(){
		return frenado;
	}

	public void hacerCambio(){
		cajaDeCambio.cambio();
		acelerar();
	}

	public void mostrarEstado(){
		System.out.println();
		System.out.println(" ----------------------------ESTADO*----------------------------- ");
		System.out.printf("| %s                                                      |\n",
			encendido());
		System.out.println("|                                                                |");
		System.out.printf("|    VELOCIDAD  : %.1f                         CAMBIO: %d         |\n",
			getVelocidad(), cajaDeCambio.getCambio());
		System.out.printf("|    ACELERACION: %.1f                         FRENO: %.1f        |\n",
			getAceleracion(), getFrenado());
		System.out.println("|                                                                |");
		System.out.println(" ___________________________----------___________________________ ");
	}

	private void sistemaInteligente(){
		switch (cajaDeCambio.getCambio()) {
			case 0:
				break;
			case 1:
				if(velocidad > -1 && velocidad < 61){

				}else if(velocidad > -11 && velocidad < 0){
					velocidad = 0;
				}else if(velocidad > 60 && velocidad < 71){
					velocidad = 60;
				}else{
					motorFundido();
				}
				break;
			case 2:
				if(velocidad > 60 && velocidad < 121){

				}else if(velocidad > 50 && velocidad < 61){
					velocidad = 61;
				}else if(velocidad > 120 && velocidad < 131){
					velocidad = 120;
				}else{
					motorFundido();
				}
				break;
			case 3:
				if(velocidad > 120 && velocidad < 181){

				}else if(velocidad > 110 && velocidad < 121){
					velocidad = 121;
				}else if(velocidad > 180 && velocidad < 191){
					velocidad = 180;
				}else{
					motorFundido();
				}
		}
	}

	public String encendido(){ // devuelve si el auto está encendido o apagado.
		String estado = "";
		if(encendido == true)
			estado = "Encendido";
		else
			estado = "Apagado  ";
		return estado;
	}

	private void motorFundido(){
		System.out.println("Motor Fundido!!!");
		apagar();
		mostrarEstado();
		System.exit(0); // termina el programa.
	}

	public void encender(){
		encendido = true;
	}

	public void apagar(){
		encendido = false;
	}

	public boolean salirAuto(){
		boolean respuesta = false;
		int salir = Integer.parseInt(Conductor.leer("Desea salir del auto? [1]Si [2]No\n-> "));
		if(salir == 1)
			respuesta = true;
		return respuesta;
	}

	private double getVelocidad(){
		return velocidad;
	}

	private double getAceleracion(){
		return aceleracion;
	}
}