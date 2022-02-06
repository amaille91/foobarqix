package foobarqix;

import static org.assertj.core.api.Assertions.assertThat;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;

public class MainTest {

	@Property
	void any_multiple_of_3_should_start_with_Fizz(@ForAll("positive integer") int number) {
		int multipleOf3 = 3 * number;

		String result = Main.compute(Integer.toString(multipleOf3));

		assertThat(result).startsWith("Fizz");
	}

	@Provide("positive integer")
	Arbitrary<Integer> positiveInteger() {
		return Arbitraries.integers().greaterOrEqual(1);
	}

}
