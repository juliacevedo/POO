package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;

public class Teatro extends Sede{

	public Teatro(String nombre, String direccion, int capacidadMaxima,int asientosPorFila,
		String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
		super(nombre, direccion, capacidadMaxima);
		crearPlateas(asientosPorFila,sectores,capacidad,porcentajeAdicional); //Metodo en Sede.
	}
	
	protected void crearPlateas(int asientosPorFila, String [] sectores, int []capacidad,int [] porcentajes) {
		this.sectores= new Sector[4];
		for (int i=0; i<sectores.length; i++) {
			this.sectores[i]= new Platea(sectores[i], capacidad[i],porcentajes[i],asientosPorFila);
		}
	}

	
	

	@Override
	protected void crearLugares(ArrayList<Tupla<String, Integer>> lugares) {
		for(Sector s : super.sectores) {
			for(int i=0; i<s.obtenerCapacidadMax(); i++) {
				lugares.add(new Tupla<>(s.obtenerSector(), i));
			}
		}
	}
	

}
