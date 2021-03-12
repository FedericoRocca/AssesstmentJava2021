package main;

import java.time.LocalDate;
import java.time.LocalDateTime;

import classes.PrestamoTasaFija;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Empezamos el main de assesstment");
		
		PrestamoTasaFija ptf = new PrestamoTasaFija(
				LocalDateTime.now(), 
				50, 
				LocalDate.now().plusDays(10), 
				100000, 
				50, 
				0, 
				0, 
				LocalDateTime.now().plusDays(1), 
				10 );
		
	}

}
