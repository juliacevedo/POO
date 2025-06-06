package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.print.attribute.standard.MediaSize.Engineering;

public class Ticketek implements ITicketek {
	private HashMap<String, Usuario> usuarios;
	private HashMap<String, Sede> sedes;
	private HashMap<String, Espectaculo> espectaculos;
	// private HashMap<String, Entrada> ventas;

	public Ticketek() {

		usuarios = new HashMap<>();
		sedes = new HashMap<>();
		espectaculos = new HashMap<>();
		// ventas = new HashMap<>();
	}

//____________________________________INTERFAZ PUBLICA_________________________________________

	@Override
	// ESTADIO
	public void registrarSede(String nombre, String direccion, int capacidadMaxima) {
		if (this.sedes.containsKey(nombre)) {
			throw new RuntimeException("La sede ya se encuentra registrada");
		}
		if (sedeConMismaDireccion(direccion)) {
			throw new RuntimeException("La direccion de la sede es incorrecta");
		}
		// La capacidad se valida en el constructor.

		Sede s = new Estadio(nombre, direccion, capacidadMaxima);
		agregarSede(nombre, s);
		
	}

	@Override
	// TEATRO
	public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila,
			String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
		if (sedes.containsKey(nombre)) {
			throw new RuntimeException("La sede ya se encuentra registrada");
		}
		if (sedeConMismaDireccion(direccion)) {
			throw new RuntimeException("La direccion de la sede es incorrecta");
		}
		Sede s = new Teatro(nombre, direccion, capacidadMaxima, asientosPorFila, sectores, capacidad,
				porcentajeAdicional);
		agregarSede(nombre, s);

	}

	@Override
	// MINIESTADIO
	public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila,
			int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad,
			int[] porcentajeAdicional) {
		if (sedes.containsKey(nombre)) {
			throw new RuntimeException("La sede ya se encuentra registrada");
		}
		if (sedeConMismaDireccion(direccion)) {
			throw new RuntimeException("La direccion de la sede es incorrecta");
		}

		Sede s = new MiniEstadio(nombre, direccion, capacidadMaxima, asientosPorFila, cantidadPuestos,
				precioConsumicion, sectores, capacidad, porcentajeAdicional);
		sedes.put(nombre, s);
	}

	@Override
	public void registrarUsuario(String email, String nombre, String apellido, String contrasenia) {
		if (usuarios.containsKey(email)) {
			throw new RuntimeException("El usuario ya esta registrado");
		}
		Usuario u = new Usuario(email, nombre, apellido, contrasenia);
		usuarios.put(email, u);
	}

	@Override
	public void registrarEspectaculo(String nombre) {
		if (espectaculos.containsKey(nombre)) {
			throw new RuntimeException("El espectaculo ya se encuentra registrado. ");
		}
		Espectaculo e = new Espectaculo(nombre);
		espectaculos.put(nombre, e);
	}

	@Override
	public void agregarFuncion(String nombreEspectaculo, String fecha, String sede, double precioBase) {
		if (!espectaculos.containsKey(nombreEspectaculo)) {
			throw new RuntimeException("El espectaculo no esta registrado");
		}
		if (!sedes.containsKey(sede)) {
			throw new RuntimeException("La sede no es valida");
		}
		if (espectaculos.get(nombreEspectaculo).fechaOcupada(fecha)) {
			throw new RuntimeException("La fecha esta ocupada");
		}
		Funcion f = new Funcion(fecha, sedes.get(sede), precioBase);
		
		espectaculos.get(nombreEspectaculo).agregarFuncion(f);

	}

	@Override 
	public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia,
			int cantidadEntradas) {
		
		if (!espectaculos.containsKey(nombreEspectaculo)) {
			throw new RuntimeException("El espectaculo no esta registrado.");
		}
		if (!usuarios.containsKey(email)) {
			throw new RuntimeException("El usuario no esta registrado");
		}
		if (!usuarios.get(email).contraseniaValida(contrasenia)) {
			throw new RuntimeException("Contraseña Invalida");
		}
		if (!espectaculos.get(nombreEspectaculo).fechaOcupada(fecha)) {
			throw new RuntimeException("El espectaculo no esta disponible en esa fecha");
		}
		if (espectaculos.get(nombreEspectaculo).sedeNumerada(fecha)) {
			throw new RuntimeException("La fecha indicada es para una sede numerada.");
		}
		Fecha fechaFuncion = new Fecha(fecha);

		List<IEntrada> vendidas = espectaculos.get(nombreEspectaculo).obtenerFuncion(fechaFuncion).venderEntrada(email, cantidadEntradas);
		for (IEntrada e : vendidas) {
			Entrada entrada = (Entrada) e;
			usuarios.get(email).agregarEntradas(entrada.obtenerCodEntrada(),entrada);
			
		}
	

		return vendidas;
	}
	
	@Override
	public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia,
			String sector, int[] asientos) {
		if (!espectaculos.containsKey(nombreEspectaculo)) {
			throw new RuntimeException("El espectaculo no esta registrado.");
		}
		if (!usuarios.containsKey(email)) {
			throw new RuntimeException("El usuario no esta registrado");
		}
		if (!usuarios.get(email).contraseniaValida(contrasenia)) {
			throw new RuntimeException("Contraseña Invalida");
		}
		if (!espectaculos.get(nombreEspectaculo).fechaOcupada(fecha)) {
			throw new RuntimeException("El espectaculo no esta disponible en esa fecha");
		}
		if (!espectaculos.get(nombreEspectaculo).sedeNumerada(fecha)) {
			throw new RuntimeException("La fecha indicada no pertenece a una sede numerada");
		}
		List<IEntrada> vendidas = espectaculos.get(nombreEspectaculo).obtenerFuncion(new Fecha(fecha)).venderEntrada(email, sector,asientos);
		for (IEntrada e : vendidas) {
			Entrada entrada = (Entrada) e;
			usuarios.get(email).agregarEntradas(entrada.obtenerCodEntrada(),entrada);
		}
		return vendidas;
	}
	
	@Override
	public String listarFunciones(String nombreEspectaculo) {
		if (!espectaculos.containsKey(nombreEspectaculo)) {
			throw new RuntimeException("El espectaculo no se encuentra registrado.");
		}
		return espectaculos.get(nombreEspectaculo).listarFunciones();
	}

	@Override
	public List<IEntrada> listarEntradasEspectaculo(String nombreEspectaculo) {
		List<IEntrada> vendidas= new ArrayList<>();
		if (!espectaculos.containsKey(nombreEspectaculo)) {
			throw new RuntimeException("El espectáculo no está registrado.");
		}
		vendidas= espectaculos.get(nombreEspectaculo).entradasVendidas();
		if( vendidas == null) {
			throw new RuntimeException("El espectaculo no vendio ninguna entrada");
		}
		return vendidas;
	}
	
	
	@Override
	
	
	public List<IEntrada> listarEntradasFuturas(String email, String contrasenia) {
		if (!usuarios.containsKey(email)) {
			throw new RuntimeException("El usuario no esta registrado");
		}
		if (!usuarios.get(email).contraseniaValida(contrasenia)) {
			throw new RuntimeException("Contraseña Invalida");
		}
		
		
		return usuarios.get(email).entradasFuturas();
	}
	
	@Override
	public List<IEntrada> listarTodasLasEntradasDelUsuario(String email, String contrasenia) {
		if (!usuarios.containsKey(email)) {
			throw new RuntimeException("El usuario no esta registrado");
		}
		if (!usuarios.get(email).contraseniaValida(contrasenia)) {
			throw new RuntimeException("Contraseña Invalida");
		}
		return usuarios.get(email).entradasCompradas();
	}
	
	
	
	// ______________________________________FALTAN_HACER___________________________________________
	
	

	@Override
	public boolean anularEntrada(IEntrada entrada, String contrasenia) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha, String sector, int asiento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double costoEntrada(String nombreEspectaculo, String fecha) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double costoEntrada(String nombreEspectaculo, String fecha, String sector) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double totalRecaudado(String nombreEspectaculo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double totalRecaudadoPorSede(String nombreEspectaculo, String nombreSede) {
		// TODO Auto-generated method stub
		return 0;
	}

	// ____________METODOS_AGREGADOS______________

	private boolean sedeConMismaDireccion(String direccion) {
		for (Sede s : sedes.values()) {
			if (s.mismaDireccion(direccion)) {
				return true;
			}
		}
		return false;
	}

	private void agregarSede(String nombre, Sede s) {
		sedes.put(nombre, s);
	}

}
