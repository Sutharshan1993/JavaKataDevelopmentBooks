/**
 * 
 */
package org.java.kata.Model;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sutharshan
 *
 */
@Getter
@Setter
public class BookRequest {
	private Map<String, Integer> books;
}
