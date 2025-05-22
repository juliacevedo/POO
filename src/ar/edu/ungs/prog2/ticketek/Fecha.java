package ar.edu.ungs.prog2.ticketek;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Fecha {
	private LocalDate fecha;

	// CONSTRUCTOR
	Fecha(String fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
		this.fecha = LocalDate.parse(fecha, formatter);
	}

	private int obtenerDia() {
		return fecha.getDayOfMonth();
	}

	private int obtenerMes() {
		return fecha.getMonthValue();
	}

	private int obtenerAnio() {
		return fecha.getYear();
	}
	// Mostrar la fecha como String "dd/MM/yyyy"
	
	@Override
	public String toString() {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    return fecha.format(formatter);
	}

	// SOBREESCRIBIR METODO EQUALS PARA QUE PODAMOS COMPARAR LAS FUNCIONES EN LA
	// CLASE ESPECTACULO POR CLAVE FECHA
	
	@Override
	public int hashCode() {
	    int resultado = 17;
	    resultado = 31 * resultado + obtenerDia();
	    resultado = 31 * resultado + obtenerMes();
	    resultado = 31 * resultado + obtenerAnio();
	    return resultado;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Fecha otra = (Fecha) obj;
		return (this.obtenerDia() == otra.obtenerDia() 
					&&	this.obtenerMes() == otra.obtenerMes()
					&& this.obtenerAnio() == otra.obtenerAnio());
	}

}
