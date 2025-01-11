/**
 * 
 */
package org.java.kata.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
		List<Integer> quantities = basket.values().stream().filter(q -> q > 0).collect(Collectors.toList());
		double totalCost = 0.0;

		while (!quantities.isEmpty()) {
			int uniqueBooks = (int) quantities.stream().filter(q -> q > 0).count();
			double discount = DiscountCalculator.getDiscount(uniqueBooks);
			double setPrice = uniqueBooks * BOOK_PRICE;
			totalCost += setPrice - (setPrice * discount);

			quantities = quantities.stream().map(q -> q > 0 ? q - 1 : 0).filter(q -> q > 0)
					.collect(Collectors.toList());
		}

		return totalCost;
	}
}
