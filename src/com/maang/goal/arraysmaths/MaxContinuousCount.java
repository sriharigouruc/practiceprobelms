package com.maang.goal.arraysmaths;

import java.util.Arrays;
import java.util.List;

public class MaxContinuousCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxContinuousCount(Arrays.asList(1,0,0,1,1,0,1,1,1,0)));
	}

	public static int maxContinuousCount(List<Integer> list)
	{
		int returnValue =0;
		int currentCount =0;
		for(int i : list)
		{
			if(i ==1)
			{
				currentCount++;
			}
			else
			{
				returnValue = returnValue>currentCount ?returnValue:currentCount;
				currentCount=0;
			}
		}
		
		return returnValue;
		
	}
	
	
}
