package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;

public class Platea extends Sector {
	private int porcentajeAdicional;
	private int asientosPorFila;
	private String[] sectores_validos = { "Platea VIP", "Platea Común", "Platea Baja", "Platea Alta" };
	private ArrayList<Tupla<Integer, Integer>> asientos;

	public Platea(String sector, int capacidad, int porcentajeAdicional, int asientosPorFila) {
		super(sector, capacidad);
		if (asientosPorFila <= 0) {
			throw new RuntimeException("Los asientos por fila debe ser mayor a cero");
		}
		if (porcentajeAdicional < 0)
			throw new RuntimeException("El porcentaje debe ser mayor a cero");

		if (!validaNombreDePlatea(sector)) {
			throw new RuntimeException("El nombre de la platea no es valido");
		}
		this.asientosPorFila = asientosPorFila;
		this.porcentajeAdicional = porcentajeAdicional;
		this.asientos = new ArrayList<>();
		generarAsientos();
	}

	private void generarAsientos() {
		Integer fila = 1;
		int control = this.asientosPorFila;
		for (Integer asiento = 1; asiento <= super.capacidad; asiento++) {
			if (asiento > control) {
				fila++;
				control += this.asientosPorFila;			}
			asientos.add(new Tupla<>(fila, asiento));
		}

	}

	private boolean validaNombreDePlatea(String platea) {
		for (String p : sectores_validos) {
			if (platea.equals(platea)) {
				return true;
			}
		}
		return false;
	}

	public int obtenerAsientosPorFila() {
		return this.asientosPorFila;
	}

	@Override
	protected String obtenerSector() {
		return super.sector;
	}

	public ArrayList<Tupla<Integer, Integer>> obtenerAsientos() {

		return asientos;
	}

}
