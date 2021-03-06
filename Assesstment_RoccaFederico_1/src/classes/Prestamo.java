package classes;

import java.time.LocalDateTime;
import java.util.ArrayList;

import excepciones.MontoIncorrectoException;
import excepciones.SinCuotasAPagarException;

public abstract class Prestamo{
	private LocalDateTime fechaOtorgamiento;
	private int plazo;
	private int diaVencimiento;
	private double montoOriginal;
	protected ArrayList<Cuota> cuotasPagas = new ArrayList<Cuota>();
	protected ArrayList<Cuota> cuotasAPagar = new ArrayList<Cuota>();
	private double montoAbonado;
	private LocalDateTime fechaProximoPago;
	protected double tasa;
	
	public Prestamo(LocalDateTime fechaOtorgamiento, int plazo, int diaVencimiento, double montoOriginal,
			double tasa) {
		super();
		
		this.fechaOtorgamiento = fechaOtorgamiento;
		this.plazo = plazo;
		this.diaVencimiento = diaVencimiento;
		this.montoOriginal = montoOriginal;
		
		double montoCuotas = (montoOriginal / plazo) * tasa;
		for( int i = 0; i < plazo; i++ )
		{
			Cuota tmpCuota = new Cuota(montoCuotas);
			cuotasAPagar.add(tmpCuota);
		}

		this.montoAbonado = 0.0f;
		actualizarFechaPago();
		
		this.tasa = tasa;
	}

	public LocalDateTime getFechaOtorgamiento() {
		return fechaOtorgamiento;
	}
	
	protected void actualizarFechaPago()
	{
		if( fechaOtorgamiento.getDayOfMonth() < diaVencimiento )
		{
			fechaProximoPago = fechaOtorgamiento.plusDays( diaVencimiento - fechaOtorgamiento.getDayOfMonth() );
		}
		else
		{
			fechaProximoPago = fechaOtorgamiento.plusMonths(1);
			fechaProximoPago = fechaProximoPago.withDayOfMonth( diaVencimiento );
		}
	}
	

	public int getPlazo() {
		return plazo;
	}

	public int getDiaVencimiento() {
		return diaVencimiento;
	}
	
	public double getCapitalAdeudado() {
		return montoOriginal - montoAbonado;
	}
	
	public boolean hasCuotasImpagas()
	{
		if( getCuotasAPagar() >= 0 )
		{
			return true;
		}
		return false;
	}
	
	public double getMontoProximaCuota()
	{
		return tasa * ( montoOriginal / (cuotasAPagar.size() + cuotasPagas.size()) );
	}

	public double getMontoOriginal() {
		return montoOriginal;
	}
	
	public void chequearCuotasAPagar() throws SinCuotasAPagarException
	{
		if( cuotasAPagar.size() <= 0 )
		{
			throw new SinCuotasAPagarException("Todas las cuotas ya fueron abonadas");
		}
	}
	
	public void cancelarSiguienteCuota(double montoPagado) throws MontoIncorrectoException, SinCuotasAPagarException {
		try
		{
			chequearCuotasAPagar();
			if( montoPagado == getMontoProximaCuota() )
			{
				cuotasPagas.add(cuotasAPagar.get(0));
				cuotasAPagar.remove(0);
				montoAbonado += montoPagado;
				actualizarFechaPago();
			}
			else {
				throw new MontoIncorrectoException("Monto incorrecto para cancelar la cuota");
			}
		}
		catch (SinCuotasAPagarException e)
		{
			throw e;
		}
	}

	public int getCuotasAPagar() {
		return cuotasAPagar.size();
	}

	public int getCuotasPagas() {
		return cuotasPagas.size();
	}

	public double getMontoAbonado() {
		return montoAbonado;
	}

	public LocalDateTime getFechaProximoPago() {
		return fechaProximoPago;
	}

	public double getTasa() {
		return tasa;
	}
}
