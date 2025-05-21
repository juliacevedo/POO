package ar.edu.ungs.prog2.ticketek;

import java.util.HashMap;

public class Entrada implements IEntrada {
	private String emailDeComprador; // AGREGADO
	private Integer codEntrada;
	private Integer codEspectaculo;
	private String nombreDeEspectaculo;
	private Fecha fecha;
	private String ubicacion;
	private static int acumulador=100;
	boolean vendida;
	
	
	
	public Entrada(int codEspectaculo, String nombreDeEspectaculo,Fecha fecha) {
		this.codEntrada = acumulador++;
		this.codEspectaculo = codEspectaculo;
		this.nombreDeEspectaculo = nombreDeEspectaculo;
		this.fecha = fecha;
	//	this.ubicacion = new HashMap<>(); 
		this.vendida=false;
	}
	
	public boolean estaVendida() {
		return vendida;
	}
	public void emailComprador(String email) {
		this.emailDeComprador=email;
	}
	public void vender() {
		this.vendida=true;
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

	public int ObtenerCodEntrada() {
		return this.codEntrada;
	}

}
