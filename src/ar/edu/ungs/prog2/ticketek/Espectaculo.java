package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Espectaculo {
	private String nombre;
	private Integer codigo;
	private HashMap<Fecha, Funcion> funciones;
	private static int acumulador = 100;
	// TOTAL RECAUDADO: DOUBLE ??

	public Espectaculo(String nombre) {
		this.nombre = nombre;
		this.codigo = acumulador++;
		this.funciones = new HashMap<>();
	
	}
	
	
	protected List<IEntrada> entradasVendidas(){
		if(!funciones.isEmpty()) {
			throw new RuntimeException("No hay funciones añadidas para esta este espectaculo");
		}
		List<IEntrada> vendidas= new ArrayList<>();
		for (Funcion f : funciones.values()) {
			vendidas.addAll(f.entradasVendidas());
		}return vendidas;
		
	}
	
	
	// ACA USAMOS STRING BUILDER PARA CONCATENAR TODAS LAS FUNCIONES DE FORMA MAS EFICIENTE YA QUE LOS STRING SON INMUTABLES 
	
	protected String listarFunciones() {
	    StringBuilder sb = new StringBuilder();
	    if(funciones.isEmpty()) {
	    	throw new RuntimeException ("No hay funciones registradas para el espectaculo.");
	    }
		for (Funcion f : funciones.values()) {
			sb.append(f.toString());
		}
		return sb.toString(); // Por que devuelve string no stringbuilder.
	}
	

	protected boolean fechaOcupada(String f) {
		Fecha otra = new Fecha(f); // HAY QUE HACER UNA COMPARACION ENTRE FECHAS CON UN METODO NUEVO EQUALS O ASI
									// YA ESTA BIEN
		return funciones.containsKey(otra);
	}

	protected void agregarFuncion(Funcion f) {
		f.crearEntradas(codigo,nombre);
		funciones.put(f.obtenerFecha(), f);
	
	}

	protected boolean sedeNumerada(String fecha) {
		Fecha f = new Fecha(fecha);
		return funciones.get(f).devolverSede().sedeNumerada();
	}


	public int obtenerCodigo() {
		return codigo;
		
	}
	
	
	protected Funcion obtenerFuncion(Fecha f) {
		
		return funciones.get(f);

	}
	

}
