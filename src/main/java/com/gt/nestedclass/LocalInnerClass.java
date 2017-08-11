package com.gt.nestedclass;


/*
 * Created inside a method								
to invoke the method of local inner class ,this local inner class to instantiated inside method only								
Local variable cant be private,public or protected								
Local inner class cant be invoked from outside method								
local inner class cant acces non final local variable till jdk1.7 of outer class								
 * 
 */
public class LocalInnerClass {

	private int data = 30;// instance variable

	void display() {
		int value = 50;// local variable must be final till jdk 1.7 only
		class Local {
			void msg() {
				System.out.println(value);
			}
		}
		Local l = new Local();
		l.msg();
	}

	public static void main(String args[]) {
		LocalInnerClass obj = new LocalInnerClass();
		obj.display();
	}
}