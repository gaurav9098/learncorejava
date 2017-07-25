package com.gt.javaeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class JavaStreamsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<Integer> stream = Stream.of(1,2,3,4);
		
		Stream<Integer> stream1 = Stream.of(new Integer[]{1,2,3,4});
		
		//Stream<Integer> stream2 = Stream.of(new int[]{1,2,3,4}); 
		
		
		//******************
		
		List<Integer> myList = new ArrayList<>();
		for(int i=0; i<100; i++) myList.add(i);
		
		
		//sequential stream
		Stream<Integer> sequentialStream = myList.stream();
		
		//parallel stream
		Stream<Integer> parallelStream = myList.parallelStream();
		
		
		Stream<String> stream3 = Stream.generate(() -> {return "abc";});
		Stream<String> stream4 = Stream.iterate("abc", (i) -> i);
		
		LongStream is = Arrays.stream(new long[]{1,2,3,4});
		IntStream is2 = "abc".chars();
		
		
		Stream<String> names = Stream.of("aBc", "d", "ef");
		System.out.println(names.map(s -> {
				return s.toUpperCase();
			}).collect(Collectors.toList()));
		//prints [ABC, D, EF]
		
		
		//sorting example
		
		Stream<String> names2 = Stream.of("aBc", "d", "ef", "123456");
		List<String> reverseSorted = names2.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(reverseSorted); // [ef, d, aBc, 123456]

		Stream<String> names3 = Stream.of("aBc", "d", "ef", "123456");
		List<String> naturalSorted = names3.sorted().collect(Collectors.toList());
		System.out.println(naturalSorted); //[123456, aBc, d, ef]
		
		// flatmap example
		//. The difference is that the map operation produces one output value for each input value, 
		//whereas the flatMap operation produces an arbitrary number (zero or more) values for each input value.
		Stream<List<String>> namesOriginalList = Stream.of(
				Arrays.asList("Pankaj"), 
				Arrays.asList("David", "Lisa"),
				Arrays.asList("Amit"));
			//flat the stream from List<String> to String stream
			Stream<String> flatStream = namesOriginalList
				.flatMap(strList -> strList.stream());
			flatStream.forEach(System.out::println);
			
			
			
			//terminal Operation
			
			Stream<Integer> numbers = Stream.of(1,2,3,4,5);
			Optional<Integer> intOptional = numbers.reduce((i,j) -> {return i*j;});
			if(intOptional.isPresent()) System.out.println("Multiplication = "+intOptional.get()); //120
			
			
			
			Stream<Integer> numbers1 = Stream.of(1,2,3,4,5);
			System.out.println("Number of elements in stream="+numbers1.count()); //5
			
			
			Stream<Integer> numbers2 = Stream.of(1,2,3,4,5);
			numbers2.forEach(i -> System.out.print(i+",")); //1,2,3,4,5,
			
			
			
			
			// stream match example
			
			Stream<Integer> numbers3 = Stream.of(1,2,3,4,5);
			System.out.println("Stream contains 4? "+numbers3.anyMatch(i -> i==4));
			//Stream contains 4? true

			Stream<Integer> numbers4 = Stream.of(1,2,3,4,5);
			System.out.println("Stream contains all elements less than 10? "+numbers4.allMatch(i -> i<10));
			//Stream contains all elements less than 10? true

			Stream<Integer> numbers5 = Stream.of(1,2,3,4,5);
			System.out.println("Stream doesn't contain 10? "+numbers5.noneMatch(i -> i==10));
			//Stream doesn't contain 10? true
			
			
			
			//Stream find first example
			
			Stream<String> names4 = Stream.of("Pankaj","Amit","David", "Lisa");
			Optional<String> firstNameWithD = names4.filter(i -> i.startsWith("D")).findFirst();
			if(firstNameWithD.isPresent()){
				System.out.println("First Name starting with D="+firstNameWithD.get()); //David
			}
			
			List<Integer> numbers12 = new ArrayList<>();
			numbers12.add(1);
			numbers12.add(2);
			numbers12.add(3);
			numbers12.add(9);
			numbers12.add(4);
			numbers12.add(5);
			System.out.println(findSquareOfMaxOdd (numbers12));			
	}
	
	public static int findSquareOfMaxOdd(List<Integer> numbers) {							
		return numbers.stream()					
				.filter(JavaStreamsExample::isOdd)			
				.filter(JavaStreamsExample::isGreaterThan3)			
				.filter(JavaStreamsExample::isLessThan11)			
				.max(Comparator.naturalOrder())			
				.map(i -> i * i)			
				.get();			
	}		
	public static boolean isOdd(int i) {return i % 2 != 0;}						
	
	public static boolean isGreaterThan3(int i){return i > 3;}						
							
	public static boolean isLessThan11(int i){return i < 11;}		
}
