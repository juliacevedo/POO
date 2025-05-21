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


	


	private Sector obtenerSector() {
		return super.sectores[0];
	}


	@Override
	protected boolean sedeNumerada() {
		return false;
	}
		
		
		
	
}
