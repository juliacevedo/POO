package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Funcion {
	private double precioBase;
	private Fecha fecha;
	private Sede sede;
	private int ventas;
	private HashMap<Integer, Entrada> entradas;

	public Funcion(String fecha, Sede sede, double precioBase) {
		if (precioBase <= 0) {
			throw new RuntimeException("El precio debe ser mayor a 0");
		}
		this.precioBase = precioBase;
		this.fecha = new Fecha(fecha);
		this.sede = sede;
		this.entradas = new HashMap<>();
		this.ventas = 0;

	}

	protected Fecha obtenerFecha() {
		return fecha;
	}

	protected Sede devolverSede() {
		return sede;
	}

//	public void crearEntradas(Integer codigo, String nombre) {
//		if (this.sede instanceof Estadio) {
//			for (int entrada = 1; entrada <= this.sede.devolverCapacidadMax(); entrada++) {
//				Entrada e = new Entrada(codigo, nombre, fecha);
//	            entradas.put(e.ObtenerCodEntrada(), e); 
//			}
//		}
//	}

	public List<IEntrada> venderEntrada(String email, int cantidadEntradas) {
		int cantidad = 0;
		List<IEntrada> lista = new ArrayList<>();
		if (ventas > cantidadEntradas) {
			throw new RuntimeException("No hay suficientes entradas disponibles");
		}
		if (this.sede instanceof Estadio) {
			for (Entrada e : entradas.values()) {
				if (cantidad > 0 && !e.estaVendida()) {
					cantidad--;
					e.estaVendida();
					e.emailComprador(email);
					lista.add(e);
					this.ventas++;
				}
			}
		}
		return lista;
	}

}
