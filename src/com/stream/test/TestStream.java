package com.stream.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {
	
	public static void main(String[] args) throws IOException {
		
		/**
		 * source: https://www.bing.com/search?q=jav+stream+exercise&form=ANNTH1&refig=8f24045c35e744589bb8328c0767043e
		 * */
		
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
		
		/**
		 * source: https://github.com/ltpitt/java-streams-exercises/blob/master/src/main/java/it/davidenastri/javastreamsexercises/StreamsExercise.java
		 * */
		
		
		Stream.of("Salvatore", "Piero", "Doneila", "Gaia", "Davide")
		.sorted()
		.findFirst()
		.ifPresent(System.out::println);;
		
		
		String[] names = {"Salvatore", "Piero", "Doneila", "Gaia", "Davide", "Daniel"};
		Arrays.stream(names)
		.filter(x -> x.startsWith("D"))
		.sorted()
		.forEach(System.out::println);;
		
		
		Arrays.stream(new int[] {2,4,6,8,10})
		.map(x -> x * x)
		.average()
		.ifPresent(System.out::println);
		
		List<String> people = Arrays.asList("Salvatore", "Piero", "Doneila", "Gaia", "Davide", "Daniel");
		people.stream()
		.map(String::toLowerCase)
		.filter(x -> x.startsWith("d"))
		.forEach(System.out::println);;
		
		Stream<String> bands = Files.lines(Paths.get("C:/Users/fedev/OneDrive/Documents/eclipse_workspaces/primary_workspace/StreamsApi/src/com/stream/bands.txt"));
		bands.sorted()
		.filter(x -> x.length() > 11)
		.forEach(System.out::println);
		
	}
}
