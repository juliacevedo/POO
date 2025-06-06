package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public abstract class Sede {
	protected String nombre;
	protected String direccion;
	protected int capacidadMaxima;
	protected Sector[] sectores;

	public Sede(String nombre, String direccion, int capacidadMaxima) {
		if (capacidadMaxima <= 0) {
			throw new RuntimeException("La capacidad debe ser mayor a 0");
		}
		if (nombre.equals("") || direccion.equals("")) {
			throw new RuntimeException("El nombre y la direccion no pueden estar vacios");
		}
		this.nombre = nombre;
		this.direccion = direccion;
		this.capacidadMaxima = capacidadMaxima;

	}

	protected String sectoresConEntradasVendidas() {
		StringBuilder sb = new StringBuilder();
		for (Sector s : this.sectores) {
			String capacidad= s.obtenerCapacidad() + "";
			sb.append(s.obtenerSector()).append(": ").append(s.obtenerVentas()).append("/").append(capacidad);

			if (!s.equals(this.sectores[this.sectores.length - 1])) {
				sb.append(" | ");
			}
		}
		return sb.toString();
	}

	protected Sector devolverSector(String s) {
		for (Sector sec : sectores) {
			if (sec.obtenerSector().equals(s)) {
				return sec;
			}
		}
		throw new RuntimeException("El sector no existe");
	}

	protected String devolverDireccion() {
		return direccion;
	}

	protected int devolverCapacidadMax() {
		return this.capacidadMaxima;
	}

	protected boolean mismaDireccion(String direccion) {
		return this.direccion.equals(direccion);
	}

	// POLIMORFISMO y SOBREESCRITURA PARA DECIR SI ES O NO NUMERADA LA SEDE
	protected abstract boolean sedeNumerada();

	public Sector[] obtenerSectores() {
		return this.sectores;
		
	}

	public String obtenerNombre() {
		return this.nombre;
	}

	@Override
	public String toString() {
		return "Sede nombre" + nombre + ", direccion=" + direccion + ", capacidadMaxima=" + capacidadMaxima
				+ ", sectores=" + Arrays.toString(sectores) + ", sede=" + ", fechas=" + "]";
	}
	
	
}
