package ar.edu.unlam.pb2;

public class PersonaFisica extends Persona {
	
	private Integer cuil;

	public PersonaFisica(String nombre, Integer dni) {
		super(nombre);
		this.setCuil(dni);
	}

	public Integer getCuil() {
		return cuil;
	}

	public void setCuil(Integer dni) {
		this.cuil = dni;
	}
	
	
}
