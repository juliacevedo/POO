package ar.edu.ungs.prog2.ticketek;

public class MiniEstadio extends Sede {

	private int capacidadPuestos;
	private double precioConsumision;
	
	
	public MiniEstadio(String nombre, String direccion, int capacidadMaxima,int asientosPorFila,int cantidadPuestos,double precioConsumicion, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
		super(nombre, direccion, capacidadMaxima);
		super.sectores= new Sector[4];
		crearPlateas(asientosPorFila,sectores,capacidad,porcentajeAdicional);

	}
	
	

}
