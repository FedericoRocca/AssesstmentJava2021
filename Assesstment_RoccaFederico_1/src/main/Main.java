package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.zip.CheckedOutputStream;

import classes.PrestamoTasaFija;

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
		System.out.println("El d�a de vencimiento es: " + ptf.getDiaVencimiento());
		System.out.println("Monto original: " + ptf.getMontoOriginal());
		System.out.println("Cuotas pagas: " + ptf.getCuotasPagas());
		System.out.println("Cuotas a pagar: " + ptf.getCuotasAPagar());
		System.out.println("Monto abonado: " + ptf.getMontoAbonado());
		System.out.println("Capital adeudado: " + ptf.getCapitalAdeudado());
		System.out.println("Tiene cuotas impagas?: " + ptf.hasCuotasImpagas());
		System.out.println("Fecha de pr�ximo pago: " + ptf.getFechaProximoPago());
		System.out.println("Tasa del prestamo: " + ptf.getTasa());
		System.out.println("Monto de pr�xima cuota: " + ptf.getMontoProximaCuota());
		System.out.println();
		System.out.println("Operaciones sobre el prestamo a tasa fija");
		System.out.println("Consultamos el monto a pagar de la pr�xima cuota.");
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
		
		
	}

}
