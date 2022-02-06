package foobarqix;

import java.math.BigInteger;

public class DivisibilityAnalyzer {
	
	public static String analyze(BigInteger number) {
		boolean isDivisibleBy3 = number.mod(new BigInteger("3")).equals(BigInteger.ZERO);
		boolean isDivisibleBy5 = number.mod(new BigInteger("5")).equals(BigInteger.ZERO);
		boolean isDivisibleBy7 = number.mod(new BigInteger("7")).equals(BigInteger.ZERO);

		String result = "";
		if(isDivisibleBy3) {
			result += "Foo";
		}
		if(isDivisibleBy5) {
			result += "Bar";
		}
		if(isDivisibleBy7) {
			result += "Qix";
		}
		
		return result;
	}

}
