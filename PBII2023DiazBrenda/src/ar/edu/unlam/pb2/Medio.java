package ar.edu.unlam.pb2;

public class Medio{
	
	private String nombre;
	private Double saldo;
	
	public Medio(String nombre, Double saldo) {
		this.nombre=nombre;
		this.saldo=saldo;
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
	
	
}
