package fr.enovacom.dojo;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class SimpleDiscountData implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
		return Stream.of(
			Arguments.of(new int[] {0, 1}, Potter.ONE_BOOK_PRICE * 2 * Potter.discountRatio.get(2)),
			Arguments.of(new int[] {1, 2, 4}, Potter.ONE_BOOK_PRICE * 3 * Potter.discountRatio.get(3)),
			Arguments.of(new int[] {0, 1, 2, 4}, Potter.ONE_BOOK_PRICE * 4 * Potter.discountRatio.get(4)),
			Arguments.of(new int[] {0, 1, 2, 3, 4}, Potter.ONE_BOOK_PRICE * 5 * Potter.discountRatio.get(5))
		);
	}
}
