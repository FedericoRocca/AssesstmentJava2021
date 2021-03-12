package classes;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PrestamoTasaFija extends Prestamo {
	
	private boolean cancelable;
	
	public PrestamoTasaFija(LocalDateTime fechaOtorgamiento, int plazo, LocalDate diaVencimiento, double montoOriginal, int cuotasAPagar,
			int cuotasPagas, double montoAbonado, LocalDateTime fechaProximoPago, double tasa) {
		super(fechaOtorgamiento, plazo, diaVencimiento, montoOriginal, cuotasAPagar, cuotasPagas, montoAbonado, fechaProximoPago, tasa);
		
	}

	@Override
	public void Cancelar() {
		// a implementar
	}

}
