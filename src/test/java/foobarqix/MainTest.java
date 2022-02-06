package foobarqix;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.Positive;

public class MainTest {

	@Property
	void any_multiple_of_3_should_start_with_Fizz(@ForAll @Positive BigInteger number) {
		BigInteger multipleOf3 = number.multiply(new BigInteger("3"));

		String result = Main.compute(multipleOf3.toString());

		assertThat(result).startsWith("Fizz");
	}

}
