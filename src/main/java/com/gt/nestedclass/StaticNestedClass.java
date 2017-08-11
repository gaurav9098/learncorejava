package com.gt.nestedclass;

/*
 * It can not access non-static member of outer class									
can be accessed by outer class name			
don’t need to craete outer object to access the inner method					
can access static data member of outer class including private									
 * 
 */
public class StaticNestedClass {

	static int data = 30;
	private int nonstatic = 20;

	static class Inner {
		static void msg() {
			System.out.println("data is " + data);

		}
	}

	public static void main(String args[]) {
		Inner inner = new Inner();
		inner.msg();
		StaticNestedClass.Inner.msg();// no need to create the instance of
										// static nested class
	}
}