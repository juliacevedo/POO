package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.HashMap;

public class Estadio extends Sede {
	private double precioUnico;
	private int vendidos;
	
	
	public Estadio(String nombre, String direccion, int capacidadMaxima) {
		super(nombre, direccion, capacidadMaxima);
		super.sectores= new Sector[1];
		sectores[0]= new Campo(capacidadMaxima);
	}


	@Override
	protected void crearLugares(HashMap<String,ArrayList<Tupla<Integer, Integer>>> lugaresDisponibles) {
		
		for(int entrada = 1; entrada<super.sectores[0].obtenerCapacidadMax(); entrada++) {
			Campo c = (Campo)super.sectores[0];
			if (!lugaresDisponibles.containsKey(c.obtenerSector())) {
			    lugaresDisponibles.put(c.obtenerSector(), new ArrayList<>());
			}
			lugaresDisponibles.get(c.obtenerSector()).add(new Tupla<>(0, entrada));
		}
		
	}


	private Sector obtenerSector() {
		return super.sectores[0];
	}


	@Override
	protected boolean sedeNumerada() {
		return false;
	}
		
		
		
	
}
