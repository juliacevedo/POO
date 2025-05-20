package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.HashMap;

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


	@Override
	protected void crearLugares(HashMap<String, ArrayList<Tupla<Integer, Integer>>> lugaresDisponibles){
		for (Sector s : super.sectores) {
			if (s instanceof Platea) {
				Platea p = (Platea) s;
				int fila = 1;
				int contador = p.obtenerAsientosPorFila();
				for (int asiento = 1; asiento <= p.obtenerCapacidadMax(); asiento++) {
					if (contador == 0) {
						contador = p.obtenerAsientosPorFila();
						fila++;
					} else {
						// Si no existe la lista para el sector, crearla
						if (!lugaresDisponibles.containsKey(p.obtenerSector())) {
						    lugaresDisponibles.put(p.obtenerSector(), new ArrayList<>());
						}

						// Agregar la tupla a la lista del sector
						lugaresDisponibles.get(p.obtenerSector()).add(new Tupla<>(fila, asiento));

					}
				}
			}
		}
	}

	@Override
	protected boolean sedeNumerada() {
		return true;
	}
	
	

	
}
