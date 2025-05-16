package ar.edu.ungs.prog2.ticketek;

public class Teatro extends Sede{

	public Teatro(String nombre, String direccion, int capacidadMaxima,int asientosPorFila,
		String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
		super(nombre, direccion, capacidadMaxima);
		crearPlateas(asientosPorFila,sectores,capacidad,porcentajeAdicional); //Metodo en Sede.
	}
	
	

}
