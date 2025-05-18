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
	
	protected boolean fechaOcupada(String f) {
		Fecha otra= new Fecha(f); // HAY QUE HACER UNA COMPARACION ENTRE FECHAS CON UN METODO NUEVO EQUALS O ASI YA ESTA BIEN
		return funciones.containsKey(otra);
	}
	
	protected void agregarFuncion(Funcion f) {
		funciones.put(f.obtenerFecha(), f);
	}
	protected boolean sedeNumerada(String fecha) {
		Fecha f= new Fecha(fecha);
		return funciones.get(f).devolverSede().sedeNumerada();
	}
	protected void venderEntrada(int cant, String fecha, String email) {
		return funciones.get(fecha).
	}
	
	


}
