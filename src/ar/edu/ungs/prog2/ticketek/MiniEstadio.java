package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;

public class MiniEstadio extends Sede {
	//SECTORES [] PLATEA VIP - PLATEA COMUN- PLATEA BAJA- PLATEA MEDIA
	private int capacidadPuestos;
	private double precioConsumision;
	
	
	public MiniEstadio(String nombre, String direccion, int capacidadMaxima,int asientosPorFila,int cantidadPuestos,double precioConsumicion, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
		super(nombre, direccion, capacidadMaxima);
		super.sectores= new Sector[4];
		crearPlateas(asientosPorFila,sectores,capacidad,porcentajeAdicional);

	}
	
	protected void crearPlateas(int asientosPorFila, String [] sectores, int []capacidad,int [] porcentajes) {
		this.sectores= new Sector[4];
		for (int i=0; i<sectores.length; i++) {
			this.sectores[i]= new Platea(sectores[i], capacidad[i],porcentajes[i],asientosPorFila);
		}
	}


	protected void crearLugares(ArrayList<Tupla<String, Integer>> lugares) {
		for(Sector s : super.sectores) {
			for(int i=0; i<s.obtenerCapacidadMax(); i++) {
				lugares.add(new Tupla<>(s.obtenerSector(), i));
			}
		}
	}

	@Override
	protected boolean sedeNumerada() {
		return true;
	}
	
	

	
}
