package ar.edu.ungs.prog2.ticketek;

import java.util.HashMap;

public class Entrada implements IEntrada {
	private String emailDeComprador; // AGREGADO
	private String codEntrada;
	private String codEspectaculo;
	private String nombreDeEspectaculo;
	private Fecha fecha;
	private HashMap<String, Tupla<Integer, Integer>> ubicacion;
	
	
	
	public Entrada(String emailDeComprador, String codEntrada, String codEspectaculo, String nombreDeEspectaculo,
			Fecha fecha) {
		this.emailDeComprador = emailDeComprador;
		this.codEntrada = codEntrada;
		this.codEspectaculo = codEspectaculo;
		this.nombreDeEspectaculo = nombreDeEspectaculo;
		this.fecha = fecha;
		this.ubicacion = new HashMap<>(); 
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
