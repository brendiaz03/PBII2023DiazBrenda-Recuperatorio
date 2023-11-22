package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class Persona {
	
	private String nombre;
	private List<Medio> mediosDePago;

	public Persona(String nombre) {
		this.nombre=nombre;
		this.mediosDePago= new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarMedio(Medio medio) {
		if(medio != null) {
			mediosDePago.add(medio);	
		}
	}

	public Integer cantidadDeMediosAsociados() {
		Integer contador = 0;
		for(Medio m : mediosDePago) {
			contador++;
		}
		return contador;
	}

	public Medio devolverMedio(String nombre) {
		for(Medio m : mediosDePago) {
			if(m.getNombre().equals(nombre)) {
				return m;
			}
		}
		return null;
	}
	
	
}
