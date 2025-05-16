package ar.edu.ungs.prog2.ticketek;

public class Estadio extends Sede {
	private double precioUnico;
	private int vendidos;
	
	
	public Estadio(String nombre, String direccion, int capacidadMaxima) {
		super(nombre, direccion, capacidadMaxima);
		super.sectores= new Sector[1];
		sectores[0]= new Campo(capacidadMaxima);
	}
}
