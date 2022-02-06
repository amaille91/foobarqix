package foobarqix;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.Predicate;
import java.util.stream.IntStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
	
	@ParameterizedTest
	@CsvSource(
			{ "1,1"
			, "2,2"
			, "3,FooFoo"
			, "4,4"
			, "5,BarBar"
			, "6,Foo"
			, "7,QixQix"
			, "8,8"
			, "9,Foo"
			, "10,Bar"
			, "13,Foo"
			, "15,FooBarBar"
			, "21,FooQix"
			, "33,FooFooFoo"
			, "37,FooQix"
			, "51,FooBar"
			, "53,BarFoo"
			, "57,FooBarQix"
			, "70,BarQixQix"
			, "73,QixFoo"
			, "75,FooBarQixBar"
			, "735,FooBarQixQixFooBar" // divisible by 3/5/7
	})
	void digits_should_be_analyzed_in_order_by_examples(int number, String expectedAnalysis_) {
		
		// palliative to JUnit CsvSource generation of strings: see https://github.com/junit-team/junit5/issues/1014
		String expectedAnalysis = expectedAnalysis_ == null ? "" : expectedAnalysis_;
		
		String result = Main.compute(Integer.toString(number));
		
		assertThat(result).isEqualTo(expectedAnalysis);
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
