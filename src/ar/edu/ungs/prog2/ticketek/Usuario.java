package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.HashMap;

public class Usuario {
	private String nombre;
	private String apellido;
	private String email;
	private String contrasenia;
	private ArrayList<Integer> entradasCompradas;

	public Usuario(String email, String nombre, String apellido, String contrasenia) {
		if (!nombreValido(nombre)) {
			throw new RuntimeException("Nombre invalido");
		}
		if (!nombreValido(apellido)) {
			throw new RuntimeException("Apellido invalido");
		}
		if (!emailValido(email)) {
			throw new RuntimeException("Email invalido, debe ser ej: usuario@aaaa.com");
		}
		if (contraseniaNuevaValida(contrasenia)) {
			throw new RuntimeException(
					"La contraseña debe tener 8 digitos como minimo y contener al menos un numero y una letra mayuscula");
		}

		this.nombre = nombre;
		this.email = email;
		this.contrasenia = contrasenia;
		this.entradasCompradas = new ArrayList<>();
	}

	// Validacion de parametros

	private boolean emailValido(String s) {
		int arroba = 0;
		boolean tienePuntoDespuesDeArroba = false;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '@') {
				arroba++;
			}
			if (arroba == 1 && s.charAt(i) == '.') {
				tienePuntoDespuesDeArroba = true;
			}
		}

		return arroba == 1 && tienePuntoDespuesDeArroba;
	}

	private boolean contraseniaNuevaValida(String s) {
		boolean tieneLetra = false;
		boolean tieneNumero = false;
		boolean tieneMayuscula = false;
		int contador = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			contador++;
			if (Character.isLetter(c)) {
				tieneLetra = true;
			}
			if (Character.isDigit(c)) {
				tieneNumero = true;
			}
			if (Character.isUpperCase(c)) {
				tieneMayuscula = true;
			}
		}

		return tieneLetra && tieneNumero && tieneMayuscula && contador >= 8;
	}

	private boolean nombreValido(String s) {
		if (s.length() < 3) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!Character.isLetter(c)) {
				return false; // No se permite ni dígito ni símbolo
			}
		}
		return true;
	}

	protected boolean contraseniaValida(String s) {
		return s.equals(obtenerContrasenia());
	}

	private String obtenerContrasenia() {
		return contrasenia;
	}

	public void agregarEntradas(Integer codEntrada) {
		entradasCompradas.add(codEntrada);
	}

}
