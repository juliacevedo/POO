package ar.edu.ungs.prog2.ticketek;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Fecha {
	private LocalDate fecha;
	
	
	//CONSTRUCTOR
	public Fecha(String fecha) {
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
	
    

	
	
	
	
}
