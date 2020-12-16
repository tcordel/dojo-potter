package fr.enovacom.dojo;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class BasicData implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
		return Stream.of(
			Arguments.of(null, 0L),
			Arguments.of(new int[] {0}, Potter.ONE_BOOK_PRICE),
			Arguments.of(new int[] {1}, Potter.ONE_BOOK_PRICE),
			Arguments.of(new int[] {2}, Potter.ONE_BOOK_PRICE),
			Arguments.of(new int[] {3}, Potter.ONE_BOOK_PRICE),
			Arguments.of(new int[] {4}, Potter.ONE_BOOK_PRICE),
			Arguments.of(new int[] {1, 1, 1}, 3 * Potter.ONE_BOOK_PRICE)
		);
	}
}
