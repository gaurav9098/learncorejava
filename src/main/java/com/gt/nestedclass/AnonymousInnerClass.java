package com.gt.nestedclass;

public class AnonymousInnerClass {
	public static void main(String args[]) {
		Eatable e = new Eatable() {
			public void eat() {
				System.out.println("nice fruits");
			}
		};
		e.eat();
	}
}

interface Eatable {
	void eat();
}
