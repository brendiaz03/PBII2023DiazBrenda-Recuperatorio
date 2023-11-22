package ar.edu.unlam.pb2;

public class QRCompra {
	
	private Integer codigo;
	private Transaccion compra;
	private Boolean isPagado;
	

	public QRCompra(Integer codigo, Transaccion compra, Boolean isPagado) {
		this.setCodigo(codigo);
		this.compra= compra;
		this.setIsPagado(isPagado);
	}


	public Transaccion getCompra() {
		return compra;
	}


	public void setCompra(Transaccion compra) {
		this.compra = compra;
	}


	public Boolean getIsPagado() {
		return isPagado;
	}


	public void setIsPagado(Boolean isPagado) {
		this.isPagado = isPagado;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
}
