package foobarqix;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.Positive;

public class DivisibilityAnalyzerTest {
	
	@Property
	void any_multiple_of_3_should_start_with_Foo(@ForAll @Positive BigInteger number) {
		BigInteger multipleOf3 = number.multiply(new BigInteger("3"));

		String result = DivisibilityAnalyzer.analyze(multipleOf3);

		assertThat(result).startsWith("Foo");
	}

	@Property
	boolean any_multiple_of_5_should_start_with_FooBar_or_Bar(@ForAll @Positive BigInteger number) {
		BigInteger multipleOf5 = number.multiply(new BigInteger("5"));

		String result = DivisibilityAnalyzer.analyze(multipleOf5);

		return result.startsWith("FooBar") || result.startsWith("Bar");
	}
	
	@Property
	boolean any_multiple_of_7_should_contain_Qix(@ForAll @Positive BigInteger number) {
		BigInteger multipleOf7 = number.multiply(new BigInteger("7"));
		
		String result = DivisibilityAnalyzer.analyze(multipleOf7);
		
		return result.startsWith("FooBarQix") || result.startsWith("BarQix") || result.startsWith("FooQix") || result.startsWith("Qix");
	}

}
