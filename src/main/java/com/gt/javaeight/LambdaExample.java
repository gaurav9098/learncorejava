package com.gt.javaeight;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class LambdaExample {

	
	public static void main (String args []){
		
		
	}
	
	
    private Map<Integer,Long> cache;

    public void Fibonacci() {
        cache = new HashMap<>();
        cache.put(0, 0L);
        cache.put(1, 1L);
    }

    public long fibonacci(int x) 
    {
        return cache.computeIfAbsent(x, n -> fibonacci(n-1) + fibonacci(n-2));
    }
    
    
    
}
