package main;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
				10 );
		
		System.out.println(ptf);
		
		System.out.println("La fecha de otorgamiento del prestamo es: " + ptf.getFechaOtorgamiento());
		System.out.println("El plazo del prestamo es: " + ptf.getPlazo());
		System.out.println("El d�a de vencimiento es: " + ptf.getDiaVencimiento());
		System.out.println("Monto original: " + ptf.getMontoOriginal());
		System.out.println("---------- Fin de prestamo a tasa fija ----------");
		
		
	}

}
