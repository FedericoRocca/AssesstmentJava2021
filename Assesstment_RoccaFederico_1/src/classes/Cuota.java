package classes;

public class Cuota
{
	private double monto;
	
	public Cuota(double montoCuotas)
	{
		setMonto(montoCuotas);
	}

	public double getMonto()
	{
		return monto;
	}

	private void setMonto(double monto)
	{
		this.monto = monto;
	}

}
