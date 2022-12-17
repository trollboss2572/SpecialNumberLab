package lab3;

public class ComplexNumber extends SpecialNumber
{
	double real;
	double imaginary;
	public ComplexNumber(double re, double imag)
	{
		real = re;
		imaginary = imag;
	}
	public ComplexNumber add(SpecialNumber x) throws Lab3Exception
	{
		if (!(x instanceof ComplexNumber))
			throw new Lab3Exception("Cannot add an incompatible type");
		ComplexNumber y = (ComplexNumber) x;
		ComplexNumber U = new ComplexNumber(real + y.real, imaginary + y.imaginary);
		return U;
	}
	public ComplexNumber divideByInt(int i) throws Lab3Exception
	{
		if (i == 0)
			throw new Lab3Exception("Cannot divide by 0");
		ComplexNumber x = new ComplexNumber(real/i, imaginary/i);
		return x;
	}
	@Override
	public int compareTo(Object y)
	{
		ComplexNumber x = (ComplexNumber)y;
		double this_mag = Math.sqrt(Math.pow(real, 2)+Math.pow(imaginary, 2));
		double that_mag = Math.sqrt(Math.pow(x.real, 2) + Math.pow(x.imaginary, 2));
		if (this_mag == that_mag)
			return 0;
		if (this_mag > that_mag)
			return 1;
		return -1;
	}
	@Override
	public boolean equals(Object x)
	{
		if (!(x instanceof ComplexNumber))
			return false;
		ComplexNumber y = (ComplexNumber)x;
		if (real == y.real && imaginary == y.imaginary)
			return true;
		return false;
	}
	public int hashCode()
	{
		return (int) (Math.round(Math.sqrt(Math.pow(real, 2)+Math.pow(imaginary, 2))));
	}
}
