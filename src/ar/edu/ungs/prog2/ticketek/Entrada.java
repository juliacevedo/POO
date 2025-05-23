package ar.edu.ungs.prog2.ticketek;

import java.util.HashMap;

public class Entrada implements IEntrada {
	private String emailDeComprador; 
	private String nombreDeSede;
	private Integer codEntrada;
	private Integer codEspectaculo;
	private String nombreDeEspectaculo;
	private String fecha;
	private String ubicacion; // Sector
	private Tupla<Integer, Integer> asiento;
	private static int acumulador = 100;

	// SOBRECARGA por que tiene dos constructores distintos.
	public Entrada(String nombreDeSede, int codEspectaculo, String nombreDeEspectaculo, Fecha fecha) {
		this.nombreDeSede = nombreDeSede;
		this.codEntrada = acumulador++;
		this.codEspectaculo = codEspectaculo;
		this.nombreDeEspectaculo = nombreDeEspectaculo;
		this.fecha = fecha.toString();
		this.ubicacion = "CAMPO";
		this.asiento = null;
		this.emailDeComprador="";
	}

	public Entrada(String nombreDeSede, int codEspectaculo, String nombreDeEspectaculo, Fecha fecha, String sector,
			Tupla<Integer, Integer> asiento) {
		this.nombreDeSede = nombreDeSede;
		this.codEntrada = acumulador++;
		this.codEspectaculo = codEspectaculo;
		this.nombreDeEspectaculo = nombreDeEspectaculo;
		this.fecha = fecha.toString();
		this.ubicacion = sector;
		this.asiento = asiento;
	}

	public void emailComprador(String email) {
		this.emailDeComprador = email;
	}

	public boolean disponible() {
	    return this.emailDeComprador == null || this.emailDeComprador.equals("");
	}
	
	protected String obtenerSector() {
		return this.ubicacion;
	}

	public int ObtenerCodEntrada() {
		return this.codEntrada;
	}
	public Tupla<Integer,Integer> obtenerAsiento() {
		return asiento;
	}

	@Override
	public double precio() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String ubicacion() {
		if(asiento==null) {
			return "CAMPO";
		}
		return this.ubicacion + " f:" + asiento.getFila() + " a:" + asiento.getAsiento();
}
		
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
