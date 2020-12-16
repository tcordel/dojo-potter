package fr.enovacom.dojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Potter {

	public static final double ONE_BOOK_PRICE = 8;
	public static final Map<Integer, Double> discountRatio = new HashMap<>();

	private final List<Set<Integer>> series = new ArrayList<>();


	static {
		discountRatio.put(1, 1d);
		discountRatio.put(2, 0.95);
		discountRatio.put(3, 0.90);
		discountRatio.put(4, 0.80);
		discountRatio.put(5, 0.75);
	}

	public double computePrice(int... books) {
		if (books == null || books.length == 0) {
			return 0;
		}
		dispatch(books);
		return getPrice();
	}

	public void dispatch(int[] books) {
		populate(books);
		reorder();
	}

	private void reorder() {
		List<Set<Integer>> seriesOf3 = filterSerieByNumberOfBook(3);
		List<Set<Integer>> seriesOf5 = filterSerieByNumberOfBook(5);

		if (seriesOf3.isEmpty() && seriesOf5.isEmpty()) {
			return;
		}

		for (Set<Integer> serieOf3 : seriesOf3) {
			pickOnBook:
			for (Set<Integer> serieOf5 : seriesOf5) {
				for (Integer book : serieOf5) {
					if (serieOf3.add(book)) {
						serieOf5.remove(book);
						break pickOnBook;
					}
				}
			}
			seriesOf5 = filterSerieByNumberOfBook(5);
		}
	}

	private List<Set<Integer>> filterSerieByNumberOfBook(int i) {
		return series.stream().filter(s -> s.size() == i).collect(Collectors.toList());
	}

	private void populate(int[] books) {
		populating:
		for (int book : books) {
			for (Set<Integer> set : series) {
				if (set.add(book)) {
					continue populating;
				}
			}
			Set<Integer> newSet = new HashSet<>();
			newSet.add(book);
			series.add(newSet);
		}
	}

	public double getPrice() {
		double price = 0;

		for (Set<Integer> integers : series) {
			final int numberOfBook = integers.size();
			price += numberOfBook * ONE_BOOK_PRICE * discountRatio.get(numberOfBook);
		}

		return price;
	}
}
