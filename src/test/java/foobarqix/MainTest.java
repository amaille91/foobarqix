package foobarqix;

import java.util.function.Predicate;
import java.util.stream.IntStream;

import org.assertj.core.api.Assertions;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;

public class MainTest {

	@Property
	void non_numeric_inputs_should_result_in_NumberFormatException(
			@ForAll("non numeric strings") String nonNumericStr) {

		try {
			Main.compute(nonNumericStr);
			Assertions.fail("Expected NumberFormatException not thrown");
		} catch (NumberFormatException e) {
			// test ok
		}

	}

	@Provide("non numeric strings")
	Arbitrary<String> nonNumericStrings() {
		return Arbitraries.strings().filter(Predicate.not(MainTest::isNumeric));
	}

	private static boolean isNumeric(String str) {
		return str.startsWith("-") || str.startsWith("+")
				? allNumericIntchars(str.substring(1).chars())
				: allNumericIntchars(str.chars());
	}

	private static boolean allNumericIntchars(IntStream charStream) {
		return charStream.filter(MainTest::isCharOtherThanDigit).findAny().isEmpty();
	}

	private static boolean isCharOtherThanDigit(int charInt) {
		return !Character.isDigit((char) charInt);
	}

}
