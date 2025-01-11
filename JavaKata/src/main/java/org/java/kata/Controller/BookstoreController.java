/**
 * 
 */
package org.java.kata.Controller;

import org.java.kata.Model.BookRequest;
import org.java.kata.Service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sutharshan
 *
 */
@RestController
@RequestMapping("/api/bookstore")
public class BookstoreController {

    @Autowired
    private BookstoreService bookstoreService;

    @PostMapping("/calculate")
    public ResponseEntity<Double> calculateTotalPrice(@RequestBody BookRequest request) {
        double totalPrice = bookstoreService.calculateTotalPrice(request.getBooks());
        return ResponseEntity.ok(totalPrice);
    }}
