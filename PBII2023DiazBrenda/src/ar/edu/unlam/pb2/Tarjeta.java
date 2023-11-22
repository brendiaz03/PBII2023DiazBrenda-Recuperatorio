package ar.edu.unlam.pb2;

public class Tarjeta extends Medio implements Pagadora{
	
	private Integer numero;

	public Tarjeta(String nombre, Integer numero, Double saldo) {
		super(nombre, saldo);
		this.setNumero(numero);
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Override
	public Boolean pagar(Medio medio, Double importe) {
		// TODO Auto-generated method stub
		return null;
	}

}
