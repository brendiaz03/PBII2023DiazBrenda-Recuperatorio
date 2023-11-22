package ar.edu.unlam.pb2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestMercadoUnlam {
	
	@Test
	public void queSePuedanAlmacenarLosDistintosTiposDeTransacciones() {
		Persona juridica = new PersonaJuridica("B", 421564669);
		Persona fisica = new PersonaFisica("D", 42156466);
		Billetera billetera = new Billetera("BrenPago", 1000.0);
		Transaccion compra = new Compra(1, 500.0, fisica, juridica);
		Transaccion transferencia = new Transferencia(2, 500.0, fisica, juridica);
		billetera.agregarTransaccion(compra);
		billetera.agregarTransaccion(transferencia);
		
		assertEquals(compra, billetera.getTransaccion(1));
		assertEquals(transferencia, billetera.getTransaccion(2));
	}
	
	@Test
	public void queSePuedanAlmacenarLosDistintosTiposDePersonas() {
		Billetera billetera = new Billetera("BrenPago", 1000.0);
		Persona juridica = new PersonaJuridica("B", 421564669);
		Persona fisica = new PersonaFisica("D", 42156466);
		
		billetera.agregarPersona(juridica);
		billetera.agregarPersona(fisica);
		
		assertEquals(juridica, billetera.getPersona(421564669));
		assertEquals(fisica, billetera.getPersona(42156466));
	}
	
	@Test
	public void queSePuedanAsociadACadaPersonaSusMedios() {
		Integer cantidadDeMediosAsociados = 4;
		
		Billetera billetera = new Billetera("BrenPago", 1000.0);
		Persona juridica = new PersonaJuridica("B", 421564669);
		Persona fisica = new PersonaFisica("D", 42156466);

		
		Medio cuentaBancaria = new CuentaBancaria("galicia", 00000, 1000.0);
		Medio cuentaVirtual = new CuentaVirtual("mp",1111, 1000.0);
		Medio tarjetaDeCredito = new TarjetaCredito("sant",1234, 1000.0);
		Medio tarjetaDeDebito = new TarjetaDebito("bbv",5678, 1000.0);
		

		juridica.agregarMedio(cuentaBancaria);
		juridica.agregarMedio(cuentaVirtual);
		juridica.agregarMedio(tarjetaDeCredito);
		juridica.agregarMedio(tarjetaDeDebito);
		billetera.agregarPersona(juridica);
		
		assertEquals(juridica, billetera.getPersona(421564669));
		assertEquals(cantidadDeMediosAsociados, billetera.getPersona(421564669).cantidadDeMediosAsociados());
	}
	
	
	@Test
	public void queSePuedanRealizarComprasParaUnaPersona() {
		Billetera billetera = new Billetera("BrenPago", 1000.0);
		
		Persona fisica = new PersonaFisica("D", 42156466);
		Persona juridica = new PersonaJuridica("B", 421564669);
		
		Medio cuentaVirtual = new CuentaVirtual("mp",1111, 1000.0);
		Medio cuentaVirtual2 = new CuentaVirtual("mp1",1111, 1000.0);
		Medio tarjetaDeCredito = new TarjetaCredito("sant",1234, 1000.0);
		Medio tarjetaDeDebito = new TarjetaDebito("bbv",5678, 1000.0);
		
		Transaccion compra = new Compra(1, 500.0, fisica, juridica);
		
		//agregar medios a cada persona
		fisica.agregarMedio(cuentaVirtual);
		fisica.agregarMedio(tarjetaDeCredito);
		fisica.agregarMedio(tarjetaDeDebito);
		
		juridica.agregarMedio(cuentaVirtual2);
		juridica.agregarMedio(tarjetaDeCredito);
		juridica.agregarMedio(tarjetaDeDebito);
		CuentaVirtual c = (CuentaVirtual) cuentaVirtual;
		
		//agregar personas a la billetera y transacciones a la billetera
		billetera.agregarPersona(fisica);
		billetera.agregarPersona(juridica);
		billetera.agregarTransaccion(compra);
		//registrar la copra una vez validado que se pago
		QRCompra compraRegistro1 = new QRCompra(1, compra, c.pagar(compra.getVendedor().devolverMedio("mp1"), 500.0) );
		billetera.queSePuedaRegistrarUnaCompra(compraRegistro1);
		
		//saldos actualizados
		Double saldoEsperadoVendedor=1500.0;
		Double saldoEsperadoComprador=500.0;
		//ver que se registro la compra
		assertEquals(compraRegistro1, billetera.getCompraDelRegistro(1));
		assertEquals(saldoEsperadoVendedor, billetera.getPersona(421564669).devolverMedio("mp1").getSaldo(), 0);
		assertEquals(saldoEsperadoComprador, billetera.getPersona(42156466).devolverMedio("mp").getSaldo(), 0);
	}
	
	@Test
	public void queSePuedanRealizarTransferencias() {
		Billetera billetera = new Billetera("BrenPago", 1000.0);
		
		Persona fisica = new PersonaFisica("D", 42156466);
		Persona juridica = new PersonaJuridica("B", 421564669);
		
		Medio cuentaVirtual = new CuentaVirtual("mp",1111, 1000.0);
		
		Medio cuentaVirtual2 = new CuentaVirtual("mp1",1111, 1000.0);
		
		Medio tarjetaDeCredito = new TarjetaCredito("sant",1234, 1000.0);
		
		Medio tarjetaDeDebito = new TarjetaDebito("bbv",5678, 1000.0);
		
		Transaccion transferencia = new Transferencia(1, 500.0, fisica, juridica);
		
		//agregar medios a cada persona
		fisica.agregarMedio(cuentaVirtual);
		fisica.agregarMedio(tarjetaDeCredito);
		fisica.agregarMedio(tarjetaDeDebito);
		
		juridica.agregarMedio(cuentaVirtual2);
		juridica.agregarMedio(tarjetaDeCredito);
		juridica.agregarMedio(tarjetaDeDebito);
		
		CuentaVirtual c = (CuentaVirtual) cuentaVirtual;
		
		//agregar personas y transacciones a la billetera
		billetera.agregarPersona(fisica);
		billetera.agregarPersona(juridica);
		billetera.agregarTransaccion(transferencia);
		
		//registrar la copra una vez validado que se pago
		QRCompra transferenciaRegistro1 = new QRCompra(1, transferencia, c.transferir(transferencia.getVendedor().devolverMedio("mp1"), 300.0));
		billetera.queSePuedaRegistrarUnaCompra(transferenciaRegistro1);
		
		//saldos actualizados
		Double saldoEsperadoVendedorJuridico=1000.0;
		Double saldoEsperadoCompradorFisica=700.0;
		//ver que se registro la compra
		assertEquals(transferenciaRegistro1, billetera.getCompraDelRegistro(1));
		assertEquals(saldoEsperadoVendedorJuridico, billetera.getPersona(421564669).devolverMedio("mp1").getSaldo(), 0);
		assertEquals(saldoEsperadoCompradorFisica, billetera.getPersona(42156466).devolverMedio("mp").getSaldo(), 0);
	}
	
	@Test
	public void queSeLanceUnaExcepcionSiElSaldoDeLaTarjetaEsInsuficienteParaHacerUnaCompra() {
		
	}
	
}
