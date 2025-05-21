package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.HashMap;

public class Teatro extends Sede {

	public Teatro(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, String[] sectores,
			int[] capacidad, int[] porcentajeAdicional) {
		super(nombre, direccion, capacidadMaxima);
		crearPlateas(asientosPorFila, sectores, capacidad, porcentajeAdicional); // Metodo en Sede.
	}

	protected void crearPlateas(int asientosPorFila, String[] sectores, int[] capacidad, int[] porcentajes) {
		this.sectores = new Platea[4];
		for (int i = 0; i < sectores.length; i++) {
			this.sectores[i] = new Platea(sectores[i], capacidad[i], porcentajes[i], asientosPorFila);
		}
	}


	

	@Override
	protected boolean sedeNumerada() {
		return true;
	}


	

}
