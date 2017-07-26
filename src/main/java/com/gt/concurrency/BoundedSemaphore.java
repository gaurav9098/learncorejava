package com.gt.concurrency;

public class BoundedSemaphore {

		  private int permit = 0;
		  private int bound   = 0;

		  public BoundedSemaphore(int upperBound){
		    this.bound = upperBound;
		  }

		  public synchronized void take() throws InterruptedException{
		    while(this.permit == bound){
		    	wait();
		    }
		    this.permit++;
		    this.notify();
		  }

		  public synchronized void release() throws InterruptedException{
		    while(this.permit == 0){
		    	wait();
		    }
		    this.permit--;
		    this.notify();
		  }
		}