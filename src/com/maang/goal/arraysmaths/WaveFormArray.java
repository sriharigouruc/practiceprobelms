package com.maang.goal.arraysmaths;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WaveFormArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> result = wave(Arrays.asList( 6, 17, 15, 13));
		List<Integer> result2 = waveWithSort(Arrays.asList( 6, 17, 15, 13));
		System.out.println(result.stream().map(Object::toString).collect(Collectors.joining(" ")));
		System.out.println(result2.stream().map(Object::toString).collect(Collectors.joining(" ")));
	}

	public static List<Integer> wave(List<Integer> A) {

		for (int i = 0; i < A.size(); i += 2) {
			if (i > 0 && A.get(i - 1) > A.get(i)) {
				swap(A, i - 1, i);
			}
			if (i < A.size() - 1 && A.get(i) < A.get(i + 1)) {
				swap(A, i, i + 1);
			}
		}

		return A;
	}

	public static void swap(List<Integer> A, int fromIndex, int toIndex) {
		int temp = A.get(toIndex);
		A.set(toIndex, A.get(fromIndex));
		A.set(fromIndex, temp);

	}
	
	public static List<Integer> waveWithSort(List<Integer> A) {
		Collections.sort(A);
		
		for (int i = 0; i < A.size()-1; i += 2) {
			
				swap(A, i , i+1);
			
		}

		return A;
	}
	
}
