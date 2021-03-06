package main;

import java.time.LocalDateTime;
import classes.PrestamoTasaFija;
import classes.PrestamoTasaVariable;
import excepciones.MontoIncorrectoException;
import excepciones.SinCuotasAPagarException;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Empezamos el main del assesstment");
		System.out.println("---------- Inicio de prestamo a tasa fija ----------");
		System.out.println("Creamos un nuevo prestamo a tasa fija con los siguientes datos:");
		
		PrestamoTasaFija ptf = new PrestamoTasaFija(
				LocalDateTime.of(2021, 1, 10, 15, 00), 
				50, 
				15, 
				100000, 
				50, 
				1.1 );
		
		System.out.println(ptf);
		
		System.out.println("La fecha de otorgamiento del prestamo es: " + ptf.getFechaOtorgamiento());
		System.out.println("El plazo del prestamo es: " + ptf.getPlazo());
		System.out.println("El d?a de vencimiento es: " + ptf.getDiaVencimiento());
		System.out.println("Monto original: " + ptf.getMontoOriginal());
		System.out.println("Cuotas pagas: " + ptf.getCuotasPagas());
		System.out.println("Cuotas a pagar: " + ptf.getCuotasAPagar());
		System.out.println("Monto abonado: " + ptf.getMontoAbonado());
		System.out.println("Capital adeudado: " + ptf.getCapitalAdeudado());
		System.out.println("Tiene cuotas impagas?: " + ptf.hasCuotasImpagas());
		System.out.println("Fecha de pr?ximo pago: " + ptf.getFechaProximoPago());
		System.out.println("Tasa del prestamo: " + ptf.getTasa());
		System.out.println("Monto de pr?xima cuota: " + ptf.getMontoProximaCuota());
		System.out.println();
		System.out.println("Operaciones sobre el prestamo a tasa fija");
		System.out.println("Consultamos el monto a pagar de la pr?xima cuota.");
		System.out.println("$" + ptf.getMontoProximaCuota());
		System.out.println("Cancelamos la primer cuota");
		try
		{
			ptf.cancelarSiguienteCuota(2200);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Monto original: " + ptf.getMontoOriginal());
		System.out.println("Monto abonado: " + ptf.getMontoAbonado());
		System.out.println("Cuotas pagas: " + ptf.getCuotasPagas());
		System.out.println("Cuotas a pagar: " + ptf.getCuotasAPagar());
		System.out.println();
		System.out.println("---------- Fin de prestamo a tasa fija ----------");
		System.out.println();
		
		System.out.println("---------- Inicio de prestamo a tasa variable ----------");
		PrestamoTasaVariable ptv = new PrestamoTasaVariable(LocalDateTime.of(2021,  2, 20, 16, 00), 20, 10, 50000, 1.2);
		System.out.println("La fecha de otorgamiento del prestamo es: " + ptv.getFechaOtorgamiento());
		System.out.println("El plazo del prestamo es: " + ptv.getPlazo());
		System.out.println("El d?a de vencimiento es: " + ptv.getDiaVencimiento());
		System.out.println("Monto original: " + ptv.getMontoOriginal());
		System.out.println("Cuotas pagas: " + ptv.getCuotasPagas());
		System.out.println("Cuotas a pagar: " + ptv.getCuotasAPagar());
		System.out.println("Monto abonado: " + ptv.getMontoAbonado());
		System.out.println("Capital adeudado: " + ptv.getCapitalAdeudado());
		System.out.println("Tiene cuotas impagas?: " + ptv.hasCuotasImpagas());
		System.out.println("Fecha de pr?ximo pago: " + ptv.getFechaProximoPago());
		System.out.println("Tasa del prestamo: " + ptv.getTasa());
		System.out.println("Monto de pr?xima cuota: " + ptv.getMontoProximaCuota());
		System.out.println();
		System.out.println("Cancelamos la primera cuota, primero con un monto incorrecto, luego con el monto correspondiente");
		try
		{
			ptv.cancelarSiguienteCuota(2000);
		}
		catch (MontoIncorrectoException e)
		{
			System.out.println(e.getMessage());
		}
		catch (SinCuotasAPagarException e)
		{
			System.out.println(e.getMessage());
		}
		
		try
		{
			ptv.cancelarSiguienteCuota(3000);
		}
		catch (MontoIncorrectoException e)
		{
			System.out.println(e.getMessage());
		}
		catch (SinCuotasAPagarException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Cuotas pagas: " + ptv.getCuotasPagas());
		System.out.println("Cuotas a pagar: " + ptv.getCuotasAPagar());
		System.out.println("Monto abonado: " + ptv.getMontoAbonado());
		System.out.println("Capital adeudado: " + ptv.getCapitalAdeudado());
		System.out.println("Fecha de pr?ximo pago: " + ptv.getFechaProximoPago());
		System.out.println("Monto de pr?xima cuota: " + ptv.getMontoProximaCuota());
		System.out.println("---------- Fin de prestamo a tasa variable ----------");
		
		
	}

}
