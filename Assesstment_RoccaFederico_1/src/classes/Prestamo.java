package classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import excepciones.MontoIncorrectoException;
import excepciones.SinCuotasAPagarException;
import interfaces.CancelacionPrestamo;

public abstract class Prestamo implements CancelacionPrestamo {
	private LocalDateTime fechaOtorgamiento;
	private int plazo;
	private int diaVencimiento;
	private double montoOriginal;
	private ArrayList<Cuota> cuotasPagas = new ArrayList<Cuota>();
	private ArrayList<Cuota> cuotasAPagar = new ArrayList<Cuota>();
	private double montoAbonado;
	private LocalDateTime fechaProximoPago;
	private double tasa;
	
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
		if( fechaOtorgamiento.getDayOfMonth() < diaVencimiento )
		{
			fechaProximoPago = fechaOtorgamiento.plusDays( diaVencimiento - fechaOtorgamiento.getDayOfMonth() );
		}
		else
		{
			fechaProximoPago = fechaOtorgamiento.plusMonths(1);
			fechaProximoPago = fechaProximoPago.withDayOfMonth( diaVencimiento );
		}
		this.tasa = tasa;
	}

	public LocalDateTime getFechaOtorgamiento() {
		return fechaOtorgamiento;
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
	
	public void cancelarSiguienteCuota(double montoPagado) throws Exception {
		try
		{
			chequearCuotasAPagar();
			if( montoPagado == getMontoProximaCuota() )
			{
				cuotasPagas.add(cuotasAPagar.get(0));
				cuotasAPagar.remove(0);
				montoAbonado += montoPagado;
			}
			else {
				throw new MontoIncorrectoException("Monto incorrecto para cancelar la cuota");
			}
		}
		catch (Exception e)
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
