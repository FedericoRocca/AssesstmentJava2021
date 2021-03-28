package classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import interfaces.CancelacionPrestamo;

public abstract class Prestamo implements CancelacionPrestamo {
	private LocalDateTime fechaOtorgamiento;
	private int plazo;
	private int diaVencimiento;
	private double montoOriginal;
	private int cuotasAPagar;
	private int cuotasPagas;
	private double montoAbonado;
	private LocalDateTime fechaProximoPago;
	private double tasa;
	
	public Prestamo(LocalDateTime fechaOtorgamiento, int plazo, int diaVencimiento, double montoOriginal, int cuotasAPagar,
			double tasa) {
		super();
		
		this.fechaOtorgamiento = fechaOtorgamiento;
		this.plazo = plazo;
		this.diaVencimiento = diaVencimiento;
		this.montoOriginal = montoOriginal;
		this.cuotasAPagar = cuotasAPagar;
		this.cuotasPagas = 0;
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

	public double getMontoOriginal() {
		return montoOriginal;
	}

	public int getCuotasAPagar() {
		return cuotasAPagar;
	}

	public int getCuotasPagas() {
		return cuotasPagas;
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
