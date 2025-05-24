package ar.edu.ungs.prog2.ticketek;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Funcion {
	private double precioBase;
	private Fecha fecha;
	private Sede sede;
	private HashMap<Integer, Entrada> entradas;

	public Funcion(String fecha, Sede sede, double precioBase) {
		if (precioBase <= 0) {
			throw new RuntimeException("El precio debe ser mayor a 0");
		}
		this.precioBase = precioBase;
		this.fecha = new Fecha(fecha);
		this.sede = sede;
		this.entradas = new HashMap<>();
	}

	protected Fecha obtenerFecha() {
		return this.fecha;
	}

	protected Sede devolverSede() {
		return sede;
	}

	public void crearEntradas(Integer codigo, String nombre) {
		if (this.sede instanceof Estadio) {
			for (int entrada = 1; entrada <= this.sede.devolverCapacidadMax(); entrada++) {
				Entrada e = new Entrada(this.sede.obtenerNombre(), codigo, nombre, fecha);
				entradas.put(e.obtenerCodEntrada(), e);
			}
			
		} else {
			for (Sector s : this.sede.obtenerSectores()) {
				if (s instanceof Platea) {
					Platea p = (Platea) s;
					for (Tupla<Integer, Integer> asiento : p.obtenerAsientos()) {
						Entrada e = new Entrada(this.sede.obtenerNombre(), codigo, nombre, fecha, s.obtenerSector(),
								asiento);
						entradas.put(e.obtenerCodEntrada(), e);
					}
				}
			}
		}

	}

	protected List<IEntrada> venderEntrada(String email, int cantidadEntradas) {
		List<IEntrada> lista = new ArrayList<>();
		if (this.sede instanceof Estadio) {
			if ((sede.devolverCapacidadMax() - sede.sectores[0].obtenerVentas()) < cantidadEntradas) {
				throw new RuntimeException("No hay suficientes entradas disponibles");
			}
			if (entradas.isEmpty()) {
				throw new RuntimeException("No hay entradas registradas");
			}
			for (Entrada e : entradas.values()) {
				if (cantidadEntradas > 0 && e.disponible()) {
					cantidadEntradas--;
					
					e.emailComprador(email);
					lista.add(e);
					sede.obtenerSectores()[0].aumentarVentas();
					
				}
			}

		}
		return lista;
	}

	protected List<IEntrada> venderEntrada(String email, String sector, int[] asientos) {
		List<IEntrada> lista = new ArrayList<>();
		if (entradasDelSector(sector).isEmpty() || !asientosDisponibles(asientos, sector)) {
			throw new RuntimeException("Al menos un asiento de los indicados se encuentra ocupado");
		}
		for (int a : asientos) {
			for (Entrada e : entradasDelSector(sector)) {
				if (e.obtenerAsiento().getAsiento() == a) {
					e.emailComprador(email);
					lista.add(e);
					this.sede.devolverSector(sector).aumentarVentas();
					;
				}
			}
		}
		return lista;
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
			if (e.obtenerSector().equals(sector)) {
				entradasDelSector.add(e);
			}
		}
		return entradasDelSector;
	}

	@Override
	public String toString() {
		if (sede instanceof Estadio) {
			return " - (" + fecha.toString() + ") " + sede.obtenerNombre() + "" + " - "
					+ sede.sectores[0].obtenerVentas() + "" + "/" + sede.devolverCapacidadMax() + "\n";
		}
		String sectores = sede.sectoresConEntradasVendidas();
		return " - (" + fecha.toString() + ") " + "" + sede.obtenerNombre() + " - " + sectores + "\n";
	}

	protected List<IEntrada> entradasVendidas() {
		List<IEntrada> vendidas = new ArrayList<>();
		if(entradas.isEmpty()) {
			throw new RuntimeException("La funcion no cuenta con entradas");
		}
		for (Entrada e : entradas.values()) {
			if (!e.disponible()) {
				vendidas.add(e);
			}
		}
		return vendidas;
	}

	
}
