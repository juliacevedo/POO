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
		this.ventas = 0;
		this.entradas = new HashMap<>();
	}

	protected Fecha obtenerFecha() {
		return fecha;
	}

	protected Sede devolverSede() {
		return sede;
	}

	public void crearEntradas(Integer codigo, String nombre) {
		if (this.sede instanceof Estadio) {
			for (int entrada = 1; entrada <= this.sede.devolverCapacidadMax(); entrada++) {
				Entrada e = new Entrada(this.sede.obtenerNombre(), codigo, nombre, fecha);
				entradas.put(e.ObtenerCodEntrada(), e);
			}
		} else {
			for (Sector s : this.sede.obtenerSectores()) {
				if (s instanceof Platea) {
					Platea p = (Platea) s;
					for (Tupla<Integer, Integer> asiento : p.obtenerAsientos()) {
						Entrada e = new Entrada(this.sede.obtenerNombre(), codigo, nombre, fecha, s.obtenerSector(),
								asiento);
						entradas.put(e.ObtenerCodEntrada(), e);
					}
				}
			}
		}

	}

	public List<IEntrada> venderEntrada(String email, int cantidadEntradas) {
		List<IEntrada> lista = new ArrayList<>();
		if ((sede.devolverCapacidadMax() - ventas) < cantidadEntradas) {
			throw new RuntimeException("No hay suficientes entradas disponibles");
		}
		if (this.sede instanceof Estadio) {
			for (Entrada e : entradas.values()) {
				if (cantidadEntradas > 0 && e.disponible()) {
					cantidadEntradas--;

					e.emailComprador(email);
					lista.add(e);
					this.ventas++;
				}
			}
		}
		return lista;
	}

	protected List<IEntrada> venderEntrada(String email, String sector, int[] asientos) {
		List<IEntrada> lista = new ArrayList<>();
		if (entradasDelSector(sector).isEmpty() || !asientosDisponibles(asientos, sector)) {
			throw new RuntimeException("Asiento no disponible");
		}
		for (int a : asientos) {
			for (Entrada e : entradasDelSector(sector)) {
				if (e.obtenerAsiento().getAsiento() == a) {
					e.emailComprador(email);
					lista.add(e);
					this.ventas++;
				}
			}
		}return lista;
	}

	private boolean asientosDisponibles(int[] asientos, String sector) {
		for (int a : asientos) {
			for (Entrada e : entradasDelSector(sector)) {
				if (e.obtenerAsiento().getAsiento() == a && !e.disponible()) {
					return false;
				}
			}
		}
		return true;
	}

	private ArrayList<Entrada> entradasDelSector(String sector) {
		ArrayList entradasDelSector = new ArrayList<>();

		for (Entrada e : this.entradas.values()) {
			if (e.obtenerUbicacion().equals(sector)) {
				entradasDelSector.add(e);
			}
		}
		return entradasDelSector;
	}
}