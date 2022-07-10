package com.maang.goal.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaxLengthSumZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> lszero(ArrayList<Integer> A) {

		ArrayList<Integer> returnList = new ArrayList<Integer>();

		ArrayList<Integer> prefixSumList = new ArrayList<Integer>();
		Map<Integer,Integer> prefixSumMap = new HashMap<Integer,Integer>();
		int currentSum = 0;
		int max_length = 0;

		for (int counter = 0; counter < A.size(); ++counter) {
			currentSum += A.get(counter);
			prefixSumList.add(currentSum);
			if (currentSum == 0) {
				max_length = counter + 1;
			}
			//if()
		}
		return returnList;
	}
}
