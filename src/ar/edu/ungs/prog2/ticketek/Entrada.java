package ar.edu.ungs.prog2.ticketek;

import java.util.HashMap;

public class Entrada implements IEntrada {
	private String emailDeComprador; // AGREGADO
	private int codEntrada;
	private int codEspectaculo;
	private String nombreDeEspectaculo;
	private Fecha fecha;
	private HashMap<String, Tupla<Integer, Integer>> ubicacion;
	private static int acumulador=100;
	
	
	
	public Entrada(String emailDeComprador, int codEspectaculo, String nombreDeEspectaculo,
			Fecha fecha) {
		this.emailDeComprador = emailDeComprador;
		this.codEntrada = acumulador++;
		this.codEspectaculo = codEspectaculo;
		this.nombreDeEspectaculo = nombreDeEspectaculo;
		this.fecha = fecha;
		this.ubicacion = new HashMap<>(); 
	}
	
	
//	private void agregarUbicacion(ArrayList<String, Tupla<Integer>) {
		
	}
	
	@Override
	public double precio() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String ubicacion() {
		// TODO Auto-generated method stub
		return null;
	}

}
