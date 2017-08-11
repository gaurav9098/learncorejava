package com.gt.nestedclass;

interface Showable {
	void show();

	interface Message {
		void msg();
	}
}

public class NestedInterfaceExample implements Showable.Message ,Showable {
	public void msg() {
		System.out.println("Hello nested interface");
	}
	@Override
	public void show() {
		System.out.println("Hello Outer interface");
		
	}
	public static void main(String args[]) {
		Showable.Message message = new NestedInterfaceExample();// upcasting  here
		message.msg();
		
		
		Showable show = new NestedInterfaceExample();
		show.show();
	}


}
