package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Billetera {
	
	private String nombre;
	private Double saldo;
	private List<Transaccion> transacciones;
	private TreeMap<Integer, Persona> personas;
	private List<QRCompra> registroTransacciones;

	public Billetera(String nombre, Double saldo) {
		this.nombre=nombre;
		this.saldo=saldo;
		this.transacciones= new ArrayList<>();
		this.personas= new TreeMap<>();
		this.registroTransacciones= new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public void agregarTransaccion(Transaccion tran) {
		if(tran != null) {
			transacciones.add(tran);
		}
		
	}

	public Transaccion getTransaccion(Integer codigo) {
		
		for(Transaccion t: transacciones) {
			if(t.getCodigo().equals(codigo)){
				if(t instanceof Compra) {
					return (Compra)t;
				}else {
					return (Transferencia)t;
				}
			}
		}
		return null;
	}

	public void agregarPersona(Persona persona) {
		if(persona != null) {
			if(persona instanceof PersonaJuridica) {
				Integer cuit = ((PersonaJuridica) persona).getCuit();
				personas.put(cuit, persona);
			}else {
				Integer cuil = ((PersonaFisica) persona).getCuil();
				personas.put(cuil, persona);
			}
		}
	}

	public Persona getPersona(Integer cod) {
		 if(personas.get(cod) != null) {
			 return personas.get(cod);
		 }
		return null;
	}

	public void queSePuedaRegistrarUnaCompra(QRCompra compra) {
		if(compra != null) {
			if(compra.getIsPagado()) {
				registroTransacciones.add(compra);
			}
			
		}
		
	}

	public QRCompra getCompraDelRegistro(Integer codigo) {
		for(QRCompra q : registroTransacciones) {
			if(q.getCodigo().equals(codigo)) {
				return q;
			}
		}
		return null;
	}

	
	

}
