package foobarqix;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	public static String compute(String nbStr) {
		BigInteger number = new BigInteger((nbStr));
		String divisibilityResult = DivisibilityAnalyzer.analyze(number);
		String numbersScanningResult = InOrderDigitsAnalyer.analyze(nbStr);
		
		String result = divisibilityResult + numbersScanningResult;
		return result.isEmpty() ? nbStr : result;
		
	}

}
