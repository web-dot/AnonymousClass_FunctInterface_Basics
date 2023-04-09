package com.stream.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {
	
	public static void main(String[] args) {
		
		
		List<Product> productRepo = new ArrayList<>(Arrays.asList(
				new Product(10, "book1", "Books", 30),
				new Product(11, "book2", "Books", 130),
				new Product(12, "book3", "Books", 70),
				new Product(13, "ipad", "Electronic", 130),
				new Product(13, "Train-Toy", "Toy", 170),
				new Product(14, "book3", "Books", 70),
				new Product(15, "laptop", "Electronic", 45),
				new Product(13, "Bus-Toy", "Toy", 30),
				new Product(13, "book4", "Books", 45),
				new Product(13, "Monopoly", "Toy", 280),
				new Product(14, "keyboard", "Electronic", 150),
				new Product(15, "book6", "Books", 110),
				new Product(16, "book7", "", 90),
				new Product(13, "Lego-Bricks", "Toy", 500)
				));
		
		/**obtain list of product belonging to category book and price > 100*/
		List<Product> books = productRepo
		.stream()
		.filter(p -> p.getCategory().equalsIgnoreCase("Books"))
		.filter(p -> p.getPrice() > 100)
		.collect(Collectors.toList());
		System.out.println(books);
		
		/**obtain a list of products belonging to the category Electronic*/
		List<Product> gadgets = productRepo
				.stream()
				.filter(p -> p.getCategory().equalsIgnoreCase("Electronic"))
				.collect(Collectors.toList());
		System.out.println(gadgets);
		
		/**obtain a list of product with category="Toy" and then apply 10% discount*/
		List<Double> toysPrices = productRepo
				.stream()
				.filter(p -> p.getCategory().equalsIgnoreCase("Toy"))
				.map(p -> p.getPrice() * .9)
				.collect(Collectors.toList());
		System.out.println(toysPrices);
		
		
		
		
		
	}
}
