package ar.edu.unlam.pb2;

public class Transaccion {
	
	private Integer codigo;
	private Double importe;
	private Persona comprador;
	private Persona vendedor;
	
	
	public Transaccion(Integer codigo, Double importe, Persona comprador, Persona vendedor) {
		this.setCodigo(codigo);
		this.importe = importe;
		this.comprador=comprador;
		this.vendedor=vendedor;
	}


	public Double getImporte() {
		return importe;
	}


	public void setImporte(Double importe) {
		this.importe = importe;
	}


	public Persona getComprador() {
		return comprador;
	}


	public void setComprador(Persona comprador) {
		this.comprador = comprador;
	}


	public Persona getVendedor() {
		return vendedor;
	}


	public void setVendedor(Persona vendedor) {
		this.vendedor = vendedor;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	
	

}
