package foobarqix;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	public static String compute(String nbStr) {
		BigInteger number = new BigInteger((nbStr));
		String divisibilityResult = DivisibilityAnalyzer.analyze(number);
		
		return divisibilityResult.isEmpty() ? nbStr : divisibilityResult;
	}

}
