package ar.edu.unlam.pb2;

public class PersonaJuridica extends Persona {
	
	private Integer cuit;
	
	public PersonaJuridica(String nombre, Integer cuit) {
		super(nombre);
		this.cuit=cuit;
	}

	public Integer getCuit() {
		return cuit;
	}

	public void setCuit(Integer cuit) {
		this.cuit = cuit;
	}
	
	
}
