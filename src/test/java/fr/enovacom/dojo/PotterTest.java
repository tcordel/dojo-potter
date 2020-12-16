package fr.enovacom.dojo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

class PotterTest {

	private final Potter potter = new Potter();

	@ParameterizedTest(name = "Books to buy : {0}, price attended : {1}")
	@ArgumentsSource(BasicData.class)
	void basicTests(int[] books, double expectedPrice) {
		double price = potter.computePrice(books);
		Assertions.assertThat(price)
			.isEqualTo(expectedPrice);
	}

	@ParameterizedTest(name = "Books to buy : {0}, price attended : {1}")
	@ArgumentsSource(SimpleDiscountData.class)
	void simpleDiscountTests(int[] books, double expectedPrice) {
		double price = potter.computePrice(books);
		Assertions.assertThat(price)
			.isEqualTo(expectedPrice);
	}

	@ParameterizedTest(name = "Books to buy : {0}, price attended : {1}")
	@ArgumentsSource(EdgeDiscountData.class)
	void edgeDiscountTests(int[] books, double expectedPrice) {
		double price = potter.computePrice(books);
		Assertions.assertThat(price)
			.isEqualTo(expectedPrice);
	}
}