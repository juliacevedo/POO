package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.List;

public class Funcion {
	private double precioBase;
	private Fecha fecha;
	private Sede sede;
	private ArrayList<Tupla<String,Integer>> entradas;
	private int ventas;
	
	
	
	
	public Funcion(String fecha, Sede sede,double precioBase) {
		if (precioBase<=0) {
			throw new RuntimeException("El precio debe ser mayor a 0");
		}
		this.precioBase = precioBase;
		this.fecha = new Fecha(fecha);
		this.sede = sede;
		this.entradas=new ArrayList<>();
		sede.crearLugares(entradas);
		
	}
	
	protected Fecha obtenerFecha() {
		return fecha;
	}
	protected Sede devolverSede() {
		return sede;
	}
	
	//SOBRECARGA SI ES OTRA SEDE
	protected List<IEntrada> venderEntrada(int cantidad, String email) {
		List<IEntrada> entradasVendidas = new ArrayList<>();
		for (int i = 0; i<cantidad; i++) {
			IEntrada i= new IEntrada()
		}
	}


}
	


