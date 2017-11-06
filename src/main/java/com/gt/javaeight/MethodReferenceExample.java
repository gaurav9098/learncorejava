package com.gt.javaeight;

public class MethodReferenceExample {
	public static void main(String args[]) {
		 //initialize order book with few orders
		 List<Order> orderBook = new  ArrayList<>(); 
		 
		 orderBook.add(new Order(1000, "GOOG.NS", 1220.17,
		 Order.Side.BUY)); 
		 orderBook.add(new Order(4000, "MSFT.NS", 37.47,
		 Order.Side.SELL)); 
		 // Sort all orders on price, using lambda expression 
		 System.out.println("Before sorting : " + orderBook);
		 Collections.sort(orderBook, (a, b) -> a.getQuantity() -  b.getQuantity()); 
		
		 // replacing lambda expression to method reference
		 // Above code can also be written like this, where 
		 // we are just 		 calling a method of Order class from 
		 // lambda expression, this can
		 //be replaced by Method 
		 // reference. 
		 Collections.sort(orderBook, (a,
		 b) -> Order.compareByQuantity(a, b));
		 Collections.sort(orderBook,		 Order::compareByQuantity); 
		 System.out.println("After sorting by order quantity : " + orderBook); 
		 		// Did you notice, two things while using
		 method reference // first, we use :: double colon to invoke method,
		 // similar to scope resolution operator of C++. // second, you don't
		 need to provide parenthesis // for method parameter, it’s just a name
		 // Similarly you can call other static method // using method
		 reference. // Another key thing is syntax of method must // match
		 with syntax of functional // interface, for example
		 compareByQuantity() syntax // is same as compare() method of //
		 Comparator interface, which is a functional // interface and
		 Collections.sort() accept // Comparator. Let's sort this List by
		 trade value Collections.sort(orderBook, Order::compareByValue);
		 System.out.println("After sorting by trade value : " + orderBook); //
		 Java supports four types of method reference, // let's see example of
		 each of them // Our previous example, in which we are // referring to

	static method was an // example of static method reference, // while
		 below 	is an	example of	instance method // reference, where we are
	invoking and	instance // method from Order class. // You can	reference	a constructor	in the	same way 
	// as a static method by	using the name new	Order order = orderBook.get(0); 
	// you need a
	reference of
	object Collections.sort(orderBook,order::compareByPrice);System.out.println("Order book after sorting
	by price:" + orderBook); // method reference example of an
	Arbitrary Object
	of a
	Particular Type // equivalent lambda expression
	for
	following would
	be // (String a, String b)->
		 a.compareToIgnoreCase(b)
	String[] symbols = { "GOOG.NS", "APPL.NS", "MSFT.NS", "AMZN.NS" };Arrays.sort(symbols,String::compareToIgnoreCase);
}}

class Order {
	public enum Side {
		BUY, SELL
	};

	private final int quantity;
	private final String symbol;
	private final double price;
	private final Side side;

	public Order(int quantity, String symbol, double price, Side side) {
		this.quantity = quantity;
		this.symbol = symbol;
		this.side = side;
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getSymbol() {
		return symbol;
	}

	public double getPrice() {
		return price;
	}

	public Side getSide() {
		return side;
	}

	@Override public
		 String toString() { return String.format("%s %d %s at price
		 %.02f",side, quantity, symbol, price); } public static int

	compareByQuantity(Order a, Order b){ return a.quantity - b.quantity;
		 }

	public int compareByPrice(Order a, Order b) {
		return Double.valueOf(a.getPrice()).compareTo(Double.valueOf(b.getPrice()));
	}

	public static int compareByValue(Order a, Order b) {
		Double tradeValueOfA = a.getPrice() * a.getQuantity();
		Double tradeValueOfB = b.getPrice() * b.getQuantity();
		return tradeValueOfA.compareTo(tradeValueOfB);
	}}
}

Read more:http:// javarevisited.blogspot.com/2017/03/what-is-method-references-in-java-8-example.html#ixzz4ri3VcDH2