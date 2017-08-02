package com.gt.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleCallableExample {
	
	
	public static void main (String [] args) throws InterruptedException, ExecutionException{
		ExecutorService executorService = Executors.newSingleThreadExecutor();						
	Future<Object> future = executorService.submit(new Callable<Object>(){				
	    public Object call() throws Exception {				
	        System.out.println("Asynchronous Callable");	
	        
	       
	        return "Callable Result";				
	    }				
	});				
	 Thread.sleep(10000);
	String result =(String)future.get();
	System.out.println("waiting for");
	System.out.println(result);
	
	executorService.shutdown();
	}
}
