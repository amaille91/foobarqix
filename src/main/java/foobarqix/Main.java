package foobarqix;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	public static String compute(String nbStr) {
		BigInteger number = new BigInteger((nbStr));
		return number.mod(new BigInteger("3")).equals(BigInteger.ZERO) ? "Fizz" : nbStr;
	}

}
