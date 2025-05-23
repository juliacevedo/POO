package ar.edu.ungs.prog2.ticketek;

public abstract class Sector {
	protected String sector;
	protected int capacidad;
	private int ventas;

	public Sector(String sector, int capacidad) {
		this.sector = sector;
		this.capacidad = capacidad;
	}

	protected int obtenerCapacidad() {
		return this.capacidad;
	}

	protected abstract String obtenerSector();

	public int obtenerVentas() {
		return ventas;
	}

	protected void aumentarVentas() {
		this.ventas++;
	}
	
}
