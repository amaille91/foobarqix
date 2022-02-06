package foobarqix;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InOrderDigitsAnalyerTest {
	
	@ParameterizedTest
	@CsvSource(
			{ "1, "
			, "2,"
			, "3,Foo"
			, "4,"
			, "5,Bar"
			, "6,"
			, "7,Qix"
			, "8,"
			, "9,"
			, "10,"
			, "13,Foo"
			, "15,Bar"
			, "21,"
			, "33,FooFoo"
			, "37,FooQix"
			, "51,Bar"
			, "53,BarFoo"
			, "57,BarQix"
			, "70,Qix"
			, "73,QixFoo"
			, "75,QixBar"
			, "735,QixFooBar"
	})
	void digits_should_be_analyzed_in_order_by_examples(int number, String expectedAnalysis_) {
		
		// palliative to JUnit CsvSource generation of strings: see https://github.com/junit-team/junit5/issues/1014
		String expectedAnalysis = expectedAnalysis_ == null ? "" : expectedAnalysis_;
		
		String result = InOrderDigitsAnalyer.analyze(Integer.toString(number));
		
		assertThat(result).isEqualTo(expectedAnalysis);
	}

}
