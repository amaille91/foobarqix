package foobarqix;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	public static String compute(String nbStr) {
		BigInteger number = new BigInteger((nbStr));
		boolean isDivisibleBy3 = number.mod(new BigInteger("3")).equals(BigInteger.ZERO);
		boolean isDivisibleBy5 = number.mod(new BigInteger("5")).equals(BigInteger.ZERO);
		boolean isDivisibleBy7 = number.mod(new BigInteger("7")).equals(BigInteger.ZERO);

		String result = "";
		if(isDivisibleBy3) {
			result += "Fizz";
		}
		if(isDivisibleBy5) {
			result += "Bar";
		}
		if(isDivisibleBy7) {
			result += "Qix";
		}
		
		return result.isEmpty() ? nbStr : result;
	}

}
