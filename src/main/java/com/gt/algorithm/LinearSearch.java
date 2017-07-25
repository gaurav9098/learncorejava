package com.gt.algorithm;

public class LinearSearch {

	public static void main (String [] args){
		
		search(new int []{32, 43, 54,23},4,43);
	}
	
	static int search(int arr[], int n, int x)
    {
        for (int i = 0; i < n; i++)
        {
            // Return the index of the element if the element
            // is found
            if (arr[i] == x)
                return i;
        }
  
        // return -1 if the element is not found
        return -1;
    }
}
