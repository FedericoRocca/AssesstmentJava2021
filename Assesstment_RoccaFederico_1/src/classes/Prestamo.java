package classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import interfaces.CancelacionPrestamo;

public abstract class Prestamo implements CancelacionPrestamo {
	private LocalDateTime fechaOtorgamiento;
	private int plazo;
	private LocalDate diaVencimiento;
	private double montoOriginal;
	private double cuotasAPagar;
	private int cuotasPagas;
	private double montoAbonado;
	private LocalDateTime fechaProximoPago;
	private double tasa;
	
	public Prestamo(LocalDateTime fechaOtorgamiento, int plazo, LocalDate diaVencimiento, double montoOriginal, int cuotasAPagar,
			int cuotasPagas, double montoAbonado, LocalDateTime fechaProximoPago, double tasa) {
		super();
		this.fechaOtorgamiento = fechaOtorgamiento;
		this.plazo = plazo;
		this.diaVencimiento = diaVencimiento;
		this.montoOriginal = montoOriginal;
		this.cuotasAPagar = cuotasAPagar;
		this.cuotasPagas = cuotasPagas;
		this.montoAbonado = montoAbonado;
		this.fechaProximoPago = fechaProximoPago;
		this.tasa = tasa;
	}

	public LocalDateTime getFechaOtorgamiento() {
		return fechaOtorgamiento;
	}

	public int getPlazo() {
		return plazo;
	}

	public LocalDate getDiaVencimiento() {
		return diaVencimiento;
	}

	public double getMontoOriginal() {
		return montoOriginal;
	}

	public double getCuotasAPagar() {
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