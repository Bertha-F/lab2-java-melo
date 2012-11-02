public class CajaDeCambio{
	private boolean[] cambio;

	public CajaDeCambio(){
		cambio = new boolean[4]; // cambio[1], cambio[2], cambio[3]; cambio[0] neutro.
	}

	public void cambio(){
		int nCambio = Integer.parseInt(Conductor.leer("Elija el cambio: [1] [2] [3]\n-> "));
		for(int i = 1; i < 4; i++){
			cambio[i] = false; // se establece todos los cambios en false.
		}
		cambio[nCambio] = true; // se establece la posicion nCambio a true, que es el cambio pedido.
	}

	public int getCambio(){ // solo un valor va ser true, y este será el cambio actual.
		int indice = 0;
		for(int i = 1; i < 4; i++){
			if(cambio[i] == true) // busca el cambio actual y guarda el indice que lo indica
				indice = i;
		}
		return indice;
	}
}