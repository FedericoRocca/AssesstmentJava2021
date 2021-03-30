package classes;

import java.time.LocalDateTime;

public class PrestamoTasaVariable extends Prestamo {

	public PrestamoTasaVariable(LocalDateTime fechaOtorgamiento, int plazo, int diaVencimiento, double montoOriginal,
			double tasa) {
		super(fechaOtorgamiento, plazo, diaVencimiento, montoOriginal, tasa);

	}

	@Override
	public String toString()
	{
		return "PrestamoTasaVariable [cuotasPagas=" + cuotasPagas + ", cuotasAPagar=" + cuotasAPagar + ", tasa=" + tasa
				+ ", getFechaOtorgamiento()=" + getFechaOtorgamiento() + ", getPlazo()=" + getPlazo()
				+ ", getDiaVencimiento()=" + getDiaVencimiento() + ", getCapitalAdeudado()=" + getCapitalAdeudado()
				+ ", getMontoProximaCuota()=" + getMontoProximaCuota() + ", getMontoOriginal()=" + getMontoOriginal()
				+ ", getCuotasAPagar()=" + getCuotasAPagar() + ", getCuotasPagas()=" + getCuotasPagas()
				+ ", getMontoAbonado()=" + getMontoAbonado() + ", getFechaProximoPago()=" + getFechaProximoPago()
				+ ", getTasa()=" + getTasa() + "]";
	}
}
