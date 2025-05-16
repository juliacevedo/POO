package ar.edu.ungs.prog2.ticketek;

import java.util.HashMap;

public abstract class Sede {
	protected String nombre;
	protected String direccion;
	protected int capacidadMazima;
	protected Sector [] sectores;
	protected String sede;
	protected HashMap<Fecha,String> fechas; 
	
	
	public Sede(String nombre, String direccion, int capacidadMazima) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.capacidadMazima = capacidadMazima;	}
	
	
}
