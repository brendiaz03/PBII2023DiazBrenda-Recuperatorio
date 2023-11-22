package ar.edu.unlam.pb2;

public interface Transferible {
	
	Double getSaldo();
	Boolean depositar(Double importe);
	Boolean extraer(Double importe);

}
