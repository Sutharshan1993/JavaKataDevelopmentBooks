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

	public static double getDiscount(int uniqueBooks) {
		switch (uniqueBooks) {
		case 2:
			return 0.05;
		case 3:
			return 0.10;
		case 4:
			return 0.20;
		case 5:
			return 0.25;
		default:
			return 0.0;
		}
	}
}
