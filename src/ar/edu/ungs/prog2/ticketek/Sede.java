package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Sede {
	protected String nombre;
	protected String direccion;
	protected int capacidadMaxima;
	protected Sector [] sectores;
	protected String sede;
	protected HashMap<Fecha,String> fechas; 
	
	
	public Sede(String nombre, String direccion, int capacidadMaxima) {
		if (capacidadMaxima<=0) {
			throw new RuntimeException("La capacidad debe ser mayor a 0");
		}
		if (nombre.equals("") || direccion.equals("")) {
			throw new RuntimeException("El nombre y la direccion no pueden estar vacios");
		}
		this.nombre = nombre;
		this.direccion = direccion;
		this.capacidadMaxima = capacidadMaxima;
		}
	
	protected String devolverDireccion() {
		return direccion;
	}

	protected boolean mismaDireccion(String direccion) {
		return this.direccion.equals(direccion); 
	}
	protected abstract void  crearLugares(HashMap<String,ArrayList<Tupla<Integer, Integer>>> lugaresDisponibles);
		
	// POLIMORFISMO y SOBREESCRITURA PARA DECIR SI ES O NO NUMERADA LA SEDE
	protected abstract boolean sedeNumerada();
	
	
	
	
}
