package com.sample.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
 
    	Integer input; 	
    	Scanner inputScanner = new Scanner(System.in);
    	System.out.println("Enter the integer");
    	input = inputScanner.nextInt();
    	boolean isPrime = false;
    	for(int counter =2 ; counter<((int) input/2); ++counter)
    	{
    		if(input%counter == 0) {
    			isPrime = true;
    			break;
    		}
    		
    	}
    	
    	System.out.println(!isPrime?"YES":"NO");
    		
    }
}