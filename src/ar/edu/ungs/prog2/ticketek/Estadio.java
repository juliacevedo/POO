package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;

public class Estadio extends Sede {
	private double precioUnico;
	private int vendidos;
	
	
	public Estadio(String nombre, String direccion, int capacidadMaxima) {
		super(nombre, direccion, capacidadMaxima);
		super.sectores= new Sector[1];
		sectores[0]= new Campo(capacidadMaxima);
	}


	@Override
	protected void crearLugares(ArrayList<Tupla<String, Integer>> lugaresDisponibles) {
			Sector s= obtenerSector();
			for(int i=0; i<s.obtenerCapacidadMax(); i++) {
					lugaresDisponibles.add(new Tupla<>(s.obtenerSector(), null)); // Si es campo asiento null
				}
			}


	private Sector obtenerSector() {
		return super.sectores[0];
	}
		
		
		
	
}
