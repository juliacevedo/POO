package ar.edu.ungs.prog2.ticketek;

import java.util.HashMap;

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

	public boolean mismaDireccion(String direccion) {
		return this.direccion.equals(direccion); 
	}
	protected void crearPlateas(int asientosPorFila, String [] sectores, int []capacidad,int [] porcentajes) {
		this.sectores= new Sector[4];
		for (int i=0; i<sectores.length; i++) {
			this.sectores[i]= new Platea(sectores[i], capacidad[i],porcentajes[i],asientosPorFila);
		}
	}
	
	
	
	
	
	
}
