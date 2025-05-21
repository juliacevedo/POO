package ar.edu.ungs.prog2.ticketek;

import java.util.HashMap;

public class Entrada implements IEntrada {
	private String emailDeComprador; // AGREGADO
	private Integer codEntrada;
	private Integer codEspectaculo;
	private String nombreDeEspectaculo;
	private Fecha fecha;
	private String ubicacion; //Sector
	private Tupla<Integer,Integer> asiento;
	private static int acumulador=100;
	boolean vendida;
	
	
	//SOBRECARGA por que tiene dos constructores distintos.
	public Entrada(int codEspectaculo, String nombreDeEspectaculo,Fecha fecha) {
		this.codEntrada = acumulador++;
		this.codEspectaculo = codEspectaculo;
		this.nombreDeEspectaculo = nombreDeEspectaculo;
		this.fecha = fecha;
		this.ubicacion = "CAMPO"; 
		this.asiento=null;
		this.vendida=false;
	}
	public Entrada(int codEspectaculo, String nombreDeEspectaculo,Fecha fecha, String sector, Tupla<Integer,Integer> asiento) {
		this.codEntrada = acumulador++;
		this.codEspectaculo = codEspectaculo;
		this.nombreDeEspectaculo = nombreDeEspectaculo;
		this.fecha = fecha;
	    this.ubicacion = sector;
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
