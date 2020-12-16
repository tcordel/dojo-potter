package fr.enovacom.dojo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Potter {

	public static final double ONE_BOOK_PRICE = 8;
	public static final Map<Integer, Double> discountRatio = new HashMap<>();
	static {
		discountRatio.put(2, 0.95);
		discountRatio.put(3, 0.90);
		discountRatio.put(4, 0.80);
		discountRatio.put(5, 0.75);
	}

	public double computePrice(int... books) {
		return 0;
	}
}
