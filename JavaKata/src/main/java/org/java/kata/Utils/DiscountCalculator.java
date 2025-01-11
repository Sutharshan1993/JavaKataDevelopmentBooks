/**
 * 
 */
package org.java.kata.Utils;

import java.util.Map;

/**
 * @author sutharshan
 *
 */
public class DiscountCalculator {

	private static final Map<Integer, Double> DISCOUNT_RATES = Map.of(1, 0.0, 2, 0.05, 3, 0.10, 4, 0.20, 5, 0.25);

	public static double getDiscount(int uniqueBooks) {
		return DISCOUNT_RATES.getOrDefault(uniqueBooks, 0.0);
	}
}
