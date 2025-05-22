package ar.edu.ungs.prog2.ticketek;

public class Tupla<S1, S2> {
    private S1 fila;
    private S2 asiento;
	
    
    
    
    public Tupla(S1 fila, S2 asiento) {
		this.fila = fila;
		this.asiento = asiento;
	}
    public S1 getFila() {
        return fila;
    }

    public S2 getAsiento() {
        return asiento;
    }

    
    
    
}
