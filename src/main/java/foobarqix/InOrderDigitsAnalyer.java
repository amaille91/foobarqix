package foobarqix;

public class InOrderDigitsAnalyer {
	
	public static String analyze(String nbStr) {
		return nbStr.chars()
				.filter(c -> ((char) c) == '3' || ((char) c) == '5' || ((char) c) == '7')
				.mapToObj(c -> specialDigitToRepresentation((char) c))
				.reduce("", String::concat);
	}
	
	private static String specialDigitToRepresentation(char c) {
		switch (c) {
		case '3':
			return "Foo";
		case '5':
			return "Bar";
		case '7':
			return "Qix";

		default:
			throw new IllegalArgumentException(String.format("cannot find representation for %s. Possible arguments are '3', '5' and '7'", Character.toString((char) c)));
		}
	}

}
