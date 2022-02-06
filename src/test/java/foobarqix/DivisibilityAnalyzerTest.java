package foobarqix;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.Positive;

public class DivisibilityAnalyzerTest {
	
	@Property
	void any_multiple_of_3_should_start_with_Fizz(@ForAll @Positive BigInteger number) {
		BigInteger multipleOf3 = number.multiply(new BigInteger("3"));

		String result = DivisibilityAnalyzer.analyze(multipleOf3);

		assertThat(result).startsWith("Fizz");
	}

	@Property
	boolean any_multiple_of_5_should_start_with_FizzBar_or_Bar(@ForAll @Positive BigInteger number) {
		BigInteger multipleOf5 = number.multiply(new BigInteger("5"));

		String result = DivisibilityAnalyzer.analyze(multipleOf5);

		return result.startsWith("FizzBar") || result.startsWith("Bar");
	}
	
	@Property
	boolean any_multiple_of_7_should_contain_Qix(@ForAll @Positive BigInteger number) {
		BigInteger multipleOf7 = number.multiply(new BigInteger("7"));
		
		String result = DivisibilityAnalyzer.analyze(multipleOf7);
		
		return result.startsWith("FizzBarQix") || result.startsWith("BarQix") || result.startsWith("FizzQix") || result.startsWith("Qix");
	}

}
