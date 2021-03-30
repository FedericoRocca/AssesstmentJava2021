package interfaces;

import excepciones.MontoIncorrectoException;
import excepciones.SinCuotasAPagarException;

public interface CancelacionPrestamo {
	public void Cancelar(double montoCancelacion) throws SinCuotasAPagarException, MontoIncorrectoException;
}
