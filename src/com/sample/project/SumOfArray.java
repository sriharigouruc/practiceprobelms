package com.sample.project;

import java.util.HashMap;

public class SumOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {-3,6,2,4,5,2,8,-9,3,1};
		
		int[] start = {4,2,1,0,7};
		int[] end = {8,7,3,4,7};
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum =0;
				
		for(int i =0; i < array.length;++i)
		{
			sum = sum+array[i];
			map.put(i, sum);
			System.out.println(i+ "-->"+ sum);
		}
		
		for (int counter = 0; counter< start.length;++counter)
		{
			Integer startN = start[counter];
			Integer endN = end[counter];
			if(startN == endN)
			{
				System.out.println(array[startN]);
			}
			else
			{
				Integer sumTillstartN =0;
				
				if(startN>0) 
					sumTillstartN = map.get(startN-1);
				
				Integer sumTillendN = map.get(endN);
				
				System.out.println(sumTillendN- sumTillstartN);
			}
			
		}
		
		
		
	}

}
