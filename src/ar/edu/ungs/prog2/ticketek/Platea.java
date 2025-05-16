package ar.edu.ungs.prog2.ticketek;

public class Platea extends Sector {
	private int porcentajeAdicional;
	private int asientosPorFila;
	private String[] sectores_validos = {"Platea VIP", "Platea Común", "Platea Baja", "Platea Alta"};
	
	
	public Platea(String sector, int capacidad,int porcentajeAdicional,int asientosPorFila) {
		super(sector, capacidad);
		if (asientosPorFila<=0) {
			throw new RuntimeException ("Los asientos por fila debe ser mayor a cero");
		}
		if(porcentajeAdicional<0)
			throw new RuntimeException ("El porcentaje debe ser mayor a cero");
		
		if(!validaNombreDePlatea(sector)) {
			throw new RuntimeException ("El nombre de la platea no es valido");
		}
		this.asientosPorFila= asientosPorFila;
		this.porcentajeAdicional= porcentajeAdicional;
	}
	
	
	private boolean validaNombreDePlatea(String platea) {
		for(String p : sectores_validos) {
			if (platea.equals(platea)) {
				return true;
			}
		}
		return false;
	}

}
