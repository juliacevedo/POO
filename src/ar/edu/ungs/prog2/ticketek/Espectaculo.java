package ar.edu.ungs.prog2.ticketek;

import java.util.HashMap;

public class Espectaculo {
	private int codigo;
	private String nombre;
	private HashMap<Fecha,Funcion> funciones;
	private static int acumulador=100;
	//TOTAL RECAUDADO: DOUBLE ??
	
	
	public Espectaculo(String nombre) {
		this.codigo = acumulador++;
		this.nombre = nombre;
		this.funciones = new HashMap<>();
	}
	
	boolean fechaOcupada(String f) {
		Fecha otra= new Fecha(f);
		return funciones.containsKey(otra);
	}
	
	
	

}
