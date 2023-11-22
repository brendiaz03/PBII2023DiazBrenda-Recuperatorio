package ar.edu.unlam.pb2;

public class CuentaVirtual extends Medio implements Pagadora, Transferible {
	
	private Integer cvu;

	public CuentaVirtual(String nombre, Integer cvu, Double saldo) {
		super(nombre, saldo);
		this.setCvu(cvu);
	}

	public Integer getCvu() {
		return cvu;
	}

	public void setCvu(Integer cvu) {
		this.cvu = cvu;
	}

	@Override
	public Boolean pagar(Medio medio, Double importe) {
		if(this.getSaldo() >= importe) {
			super.setSaldo(super.getSaldo()-importe);
			medio.setSaldo(medio.getSaldo()+importe);
			return true;
		}
		return false;
	}

	@Override
	public Boolean depositar(Double importe) {
		super.setSaldo(super.getSaldo()+importe);
		return true;	
	}

	@Override
	public Boolean extraer(Double importe) {
		if(getSaldo()>=importe) {
			setSaldo(getSaldo()-importe);
			return true;
		}
		return false;
	}

	public Boolean transferir(Medio medio, double d) {
		if(extraer(d)) {
			medio.setSaldo(getSaldo()+d);
			return true;
		}
		return false;
	}

}
