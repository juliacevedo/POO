package ar.edu.ungs.prog2.ticketek;

public abstract class Sector {
	protected String sector;
	protected int capacidad;
	
	
	
	public Sector(String sector, int capacidad) {
		super();
		this.sector = sector;
		this.capacidad = capacidad;
	}
	
	
}
