package ar.edu.unlam.pb2;

public class CuentaBancaria extends Medio implements Transferible {
	
	private Integer cbu;

	public CuentaBancaria(String nombre, Integer cbu, Double saldo) {
		super(nombre, saldo);
		this.setCbu(cbu);
	}

	public Integer getCbu() {
		return cbu;
	}

	public void setCbu(Integer cbu) {
		this.cbu = cbu;
	}

	@Override
	public Boolean depositar(Double importe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean extraer(Double importe) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
