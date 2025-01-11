/**
 * 
 */
package org.java.kata.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.java.kata.Utils.DiscountCalculator;
import org.springframework.stereotype.Service;

/**
 * @author sutharshan
 *
 */
@Service
public class BookstoreServiceImpl implements BookstoreService {

	private static final double BOOK_PRICE = 50.0;

	@Override
	public double calculateTotalPrice(Map<String, Integer> basket) {

		Map<String, Integer> mutableBasket = new HashMap<>(basket);
		List<Integer> uniqueSetSizes = getUniqueSetSizes(mutableBasket);
		double totalPrice = uniqueSetSizes.stream().mapToDouble(this::calculateSetPrice).sum();

		// Round the final total price to 2 decimal places
		return Math.round(totalPrice * 100.0) / 100.0;
	}

	private List<Integer> getUniqueSetSizes(Map<String, Integer> basket) {
		List<Integer> uniqueSetSizes = new ArrayList<>();

		while (basket.values().stream().anyMatch(count -> count > 0)) {
			// Create a unique set of books
			Set<String> uniqueSet = basket.entrySet().stream().filter(entry -> entry.getValue() > 0).map(Map.Entry::getKey).collect(Collectors.toSet());

			// Add the size of this set to the list
			uniqueSetSizes.add(uniqueSet.size());
			// Decrease the count for each book in the set
			uniqueSet.forEach(book -> {
				int currentCount = basket.get(book);
				if (currentCount > 0) {
					basket.put(book, currentCount - 1);
				}
			});

			// Debug: Show the current basket and unique set
			System.out.println("Basket after forming set: " + basket);
		}

		return uniqueSetSizes;
	}

	private double calculateSetPrice(int setSize) {
		double discount = DiscountCalculator.getDiscount(setSize);
		double setPrice = setSize * BOOK_PRICE;

		return setPrice * (1 - discount);
	}
}
