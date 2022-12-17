package lab3;
import java.util.List;
import java.lang.Comparable;

@SuppressWarnings("rawtypes")
public abstract class SpecialNumber implements Comparable{
	public abstract SpecialNumber add(SpecialNumber x) throws Lab3Exception;
	public abstract SpecialNumber divideByInt(int i) throws Lab3Exception;
	/**
	 * This method returns the average value of a list of instances of SpecialNumber
	 * @param ListOfInstances of subclasses of SpecialNumber
	 * @return AverageValue of the elements in the list, in whatever format that subclass is in
	 * @throws listEmptyException if the input list is empty or the parameter pointer does not point to any list
	 */
	public static SpecialNumber computeAverage(List<SpecialNumber> UwU) throws Lab3Exception
	{
		if(UwU == null || UwU.isEmpty())
			throw new Lab3Exception("List cannot be empty");
		int length = UwU.size();
		SpecialNumber result = UwU.get(0);
		for (int i = 1; i < length; i++)
			result = result.add(UwU.get(i));
		System.out.println(result);
		return (result.divideByInt(length));
	}
}
