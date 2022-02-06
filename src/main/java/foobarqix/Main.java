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

		return isDivisibleBy3 && isDivisibleBy5 ? "FizzBar"
				: isDivisibleBy3 ? "Fizz"
				: isDivisibleBy5 ? "Bar"
				: nbStr;
	}

}
