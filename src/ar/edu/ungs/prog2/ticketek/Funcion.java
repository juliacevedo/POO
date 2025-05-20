package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Funcion {
	private double precioBase;
	private Fecha fecha;
	private Sede sede;
	private HashMap<String, ArrayList<Tupla<Integer, Integer>>>  entradas; //HashMap<Sector,Tupla<Integer fila, Integer asiento>>:
	private int ventas;
	
	
	
	
	public Funcion(String fecha, Sede sede,double precioBase) {
		if (precioBase<=0) {
			throw new RuntimeException("El precio debe ser mayor a 0");
		}
		this.precioBase = precioBase;
		this.fecha = new Fecha(fecha);
		this.sede = sede;
		this.entradas=new HashMap<>();
		sede.crearLugares(entradas);
		this.ventas=0;
		
	}
	
	protected Fecha obtenerFecha() {
		return fecha;
	}
	protected Sede devolverSede() {
		return sede;
	}




}
	


