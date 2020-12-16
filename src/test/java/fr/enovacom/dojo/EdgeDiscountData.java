package fr.enovacom.dojo;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class EdgeDiscountData implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
		return Stream.of(
			Arguments.of(new int[] {0, 0, 1, 1, 2, 2, 3, 4}, 2 * (Potter.ONE_BOOK_PRICE * 4 * Potter.discountRatio.get(4))),
			Arguments.of(new int[] {
				0, 0, 0, 0, 0,
				1, 1, 1, 1, 1,
				2, 2, 2, 2,
				3, 3, 3, 3, 3,
				4, 4, 4, 4},
				3 * (Potter.ONE_BOOK_PRICE * 5 * Potter.discountRatio.get(3)) + 2 * (Potter.ONE_BOOK_PRICE * 4 * Potter.discountRatio.get(4))
				)
		);
	}
}
