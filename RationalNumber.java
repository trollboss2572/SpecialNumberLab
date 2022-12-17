package lab3;

public class RationalNumber extends SpecialNumber 
{
	int num;
	int den;
	/**
	 * The constructor accepts 2 inputs of type int
	 */
	public RationalNumber(int n, int d) throws Lab3Exception
	{
		if (d == 0)
			throw new Lab3Exception("Denominator cannot be zero");
		num = n;
		den = d;
	}
	/**
	 * The add function multiplies the numerators by the other denominator 
	 * and adds them and multiplies the denominators together to get a new
	 * rational number that works in the general case regardless of differing
	 * denominator
	 */
	public RationalNumber add(SpecialNumber other) throws Lab3Exception
	{
		if (!(other instanceof RationalNumber))
				throw new Lab3Exception("Cannot add an incompatible type");
		RationalNumber other2 = (RationalNumber)other;
		int n = (num*other2.den)+other2.num*den;
		int d = (den*other2.den);
		RationalNumber x = new RationalNumber(n,d); 
		return x;
	}
	/**
	 * Divides the rational number by an integer by multiplying the denominator
	 * by that integer
	 */
	public SpecialNumber divideByInt(int i) throws Lab3Exception 
	{
		if (i == 0)
			throw new Lab3Exception("Cannot divide by zero");
		int d = den * i;
		RationalNumber x = new RationalNumber(num,d);
		return x;
	}
	/**
	 * Returns the RationalNumber as a hashcode by reducing the 
	 * rational number into simplest form, then multiplying the numerator by the denominator,
	 * thus producing a unique hashcode for each rational number.
	 */
	public int hashCode()
	{
		int reduced_num = num;
		int reduced_den = den;
		int i = 2;
		while (i <= Math.min(reduced_num,reduced_den))
		{
			if (reduced_num % i == 0 && reduced_den % i == 0)
			{
				reduced_num = reduced_num / i;
				reduced_den = reduced_den / i;
			}
			if (reduced_num % i != 0 || reduced_den % i != 0)
				i++;
		}		
		int result = reduced_num * reduced_den;
		return result;
	}
	/**
	 * This comparison function directly divides the numerator
	 * and denominator of each rational number and compares the 
	 * end result to see if they are equal or which one is great than
	 * the other
	 */
	@Override
	public int compareTo(Object x)
	{
		RationalNumber y = (RationalNumber)x;
		if (num/den == y.num/y.den)
			return 0;
		if (num/den > y.num/y.den)
			return 1;
		return -1;
	}
	/**
	 * Uses the comparison function to find whether 2 rational numbers
	 * are equal to each other 
	 */
	@Override
	public boolean equals(Object x)
	{
		if (!(x instanceof RationalNumber))
			return false;
		RationalNumber y = (RationalNumber)x;
		if (compareTo(y) == 0)
			return true;
		return false;
	}
}
