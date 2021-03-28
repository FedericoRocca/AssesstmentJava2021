package classes;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PrestamoTasaFija extends Prestamo {
	public PrestamoTasaFija(LocalDateTime fechaOtorgamiento, int plazo, int diaVencimiento, double montoOriginal, int cuotasAPagar,
			double tasa) {
		super(fechaOtorgamiento, plazo, diaVencimiento, montoOriginal, tasa);
		
	}

	@Override
	public void Cancelar() {
		// a implementar
	}

	@Override
	public String toString()
	{
		return "Prestamo de tasa fija: [Fecha de otorgamiento: " + getFechaOtorgamiento() + ", plazo: " + getPlazo()
				+ ", dia de vencimiento: " + getDiaVencimiento() + ", monto original: $" + getMontoOriginal()
				+ ", Cuotas a pagar: " + getCuotasAPagar() + ", Cuotas pagas: " + getCuotasPagas()
				+ ", Monto abonado: $" + getMontoAbonado() + ", Fecha de próximo pago: " + getFechaProximoPago()
				+ ", Tasa: " + getTasa() + "]";
	}

}
