package com.streams.test;

import java.util.ArrayList;
import java.util.List;


/**local class / Functional Interface*/
interface Eligibles{
	public boolean test(int age);
}

class EligiblesCount implements Eligibles{
	@Override
	public boolean test(int age) {
		return (age > 18 && age <= 28);
	}
}



public class StreamTest {
	
	/**
	 * static method
	 * This is very brittle as the implementation might change in future
	 * */
	public static int countEligibles(List<Candidate> candidates) {
		int count = 0;
		for(Candidate c : candidates) {
			if(c.getAge() > 18 && c.getAge() <= 28) {
				count++;
			}
		}
		return count;
	}
	
	
	
	public static int countEligiblesUsingClass(List<Candidate> candidates, Eligibles filter) {
		int count = 0;
		for(Candidate c : candidates) {
			if(filter.test(c.getAge())) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		List<Candidate> candidates = new ArrayList<>();
		Candidate c1 = new Candidate("Jamie", 19);
		Candidate c2 = new Candidate("Austin", 23);
		Candidate c3 = new Candidate("Kelly", 15);
		Candidate c4 = new Candidate("Ryan", 32);
		Candidate c5 = new Candidate("Mickey", 18);
		Candidate c6 = new Candidate("Patrick", 20);
		Candidate c7 = new Candidate("Ferdinand", 37);
		Candidate c8 = new Candidate("Liddy", 25);
		Candidate c9 = new Candidate("Fiona", 28);
		
		candidates.add(c1);
		candidates.add(c2);
		candidates.add(c3);
		candidates.add(c4);
		candidates.add(c5);
		candidates.add(c6);
		candidates.add(c7);
		candidates.add(c8);
		candidates.add(c9);
		
		/**This is very brittle as the implementation might change in future*/
		int eligible_candidates = countEligibles(candidates);
		System.out.println("using method : " + eligible_candidates);
		
		
		/**This is not very convenient as every time instance has to be created*/
		EligiblesCount EC = new EligiblesCount();
		int eligiblesByClass = countEligiblesUsingClass(candidates, EC);
		System.out.println("using class : " + eligiblesByClass);
		
		/**
		 * passing a method parameter using a `anonymous inner class`, that does below in same point in time
		 * 1. implements the interface
		 * 2. creates an object of the class that implements and overrides the functionality
		 * */
		int eligibelsWhenAnonym = countEligiblesUsingClass(candidates, new Eligibles() {
			@Override
			public boolean test(int age) {
				return (age > 18 && age <= 28); 
			}
		});
		System.out.println("using anonymous class filter parameter : " + eligibelsWhenAnonym);
		
		/**
		 * A `Anonymous class expression` can be replaced by a `Lambda Expression`
		 * */
		int eligibles = countEligiblesUsingClass(candidates, age -> age > 18 && age <= 28);
		System.out.println("using Lambda Expression filter parameter: " + eligibles);
	}
}
