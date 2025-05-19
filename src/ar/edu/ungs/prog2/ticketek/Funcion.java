package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.Iterator;
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
		this.ventas=0;
		
	}
	
	protected Fecha obtenerFecha() {
		return fecha;
	}
	protected Sede devolverSede() {
		return sede;
	}

	public ArrayList<Tupla<String,Integer>> reservar(int cantidad) {
		ArrayList<Tupla<String,Integer>> entradasVendidas=new ArrayList<>();
		if (entradas.isEmpty() || cantidad > entradas.size()) {
			throw new RuntimeException ("No hay mas lugares disponibles");
		}
		for (int i=0; i<cantidad; i++){
			 Tupla<String, Integer> tupla = entradas.remove(0); // Saca el primero
			 entradasVendidas.add(tupla); 
			 this.ventas++;
			 
		}
		return entradasVendidas;
	}
	
//	//SOBRECARGA SI ES OTRA SEDE
//	protected List<IEntrada> venderEntrada(int cantidad, String email, int codigo, String nombre) {
//		List<IEntrada> entradasVendidas = new ArrayList<>();
//		Iterator<Tupla<String,Integer>> lugares= entradas.iterator();
//		while(lugares.hasNext()) {
//			Tupla<String,Integer> lugar=lugares.next();
//			if(cantidad==0) {
//				return entradasVendidas;
//			}
//			else {
//				cantidad--;
//				IEntrada= new IEntrada(email,this.fecha, codigo, nombre);
//			}
//		}
//	}


}
	


