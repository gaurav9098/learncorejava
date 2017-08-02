package com.gt.operators;


/*
 * 


~       Unary bitwise complement
<<      Signed left shift
>>      Signed right shift
>>>     Unsigned right shift
&       Bitwise AND
^       Bitwise exclusive OR
|       Bitwise inclusive OR


 */
public class BitDemo {
	
	public static void main (String [] args){
	// x is stored using 32 bit 2's complement form. 
    // Binary representation of -1 is all 1s (111..1)       
    int x = -1;  
System.out.println(Integer.toBinaryString(x));
int k =x>>>30;
System.out.println(Integer.toBinaryString(k));
    System.out.println(k);  // The value of 'x>>>29' is 00...0111
    
    System.out.println(Integer.toBinaryString(x));
    System.out.println(x>>>30);  // The value of 'x>>>30' is 00...0011
    System.out.println(Integer.toBinaryString(x));
    System.out.println(x>>>31);  // The value of 'x>>>31' is 00...0001
    System.out.println(Integer.toBinaryString(x));
	}
}
