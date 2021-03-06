package classes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import excepciones.MontoIncorrectoException;
import excepciones.SinCuotasAPagarException;
import excepciones.TasaIncorrectaException;
import interfaces.CancelacionPrestamo;

public class PrestamoTasaFijaCancelable extends PrestamoTasaFija implements CancelacionPrestamo
{

	public PrestamoTasaFijaCancelable(LocalDateTime fechaOtorgamiento, int plazo, int diaVencimiento,
			double montoOriginal, int cuotasAPagar, int cuotasPagas, double montoAbonado,
			LocalDateTime fechaProximoPago, double tasa)
	{
		super(fechaOtorgamiento, plazo, diaVencimiento, montoOriginal, cuotasAPagar,
			 tasa);
		// TODO Auto-generated constructor stub
	}
	
	private void setTasa(double _tasa) throws TasaIncorrectaException
	{
		if( _tasa >= 0 )
		{
			tasa = _tasa;
		}
		else 
		{
			throw new TasaIncorrectaException("El valor ingresado para la tasa es incorrecto");
		}
	}
	
	public void modificarTasa(double newTasa) throws TasaIncorrectaException
	{
		try
		{
			setTasa(newTasa);
		}
		catch (TasaIncorrectaException e)
		{
			throw e;
		}
	}

	@Override
	public void Cancelar(double montoCancelacion) throws SinCuotasAPagarException, MontoIncorrectoException
	{
		try
		{
			if( getCuotasAPagar() <= 0 )
			{
				throw new SinCuotasAPagarException("No hay cuotas pendientes por pagar");
			}
			else {
				for( int i = 0; i < cuotasAPagar.size(); i++ )
				{
					cancelarSiguienteCuota(i);
				}
			}
		}
		catch (SinCuotasAPagarException e)
		{
			throw e;
		}
		catch (MontoIncorrectoException e)
		{
			throw e;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
