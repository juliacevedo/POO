package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;

public class Funcion {
	private double precioBase;
	private Fecha fecha;
	private Sede sede;
	private ArrayList<Tupla<String,Integer>> entradas;
	
	
	
	
	public Funcion(double precioBase, Fecha fecha, Sede sede, ArrayList<Tupla<String, Integer>> entradas) {
		if (precioBase<=0) {
			throw new RuntimeException("El precio debe ser mayor a 0");
		}
		this.precioBase = precioBase;
		this.fecha = fecha;
		this.sede = sede;
		sede.crearLugares(this.entradas);
		
	}
	

}
	


