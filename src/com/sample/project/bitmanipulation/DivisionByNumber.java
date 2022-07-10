package com.sample.project.bitmanipulation;

public class DivisionByNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMod("6562800446546751053033681283622332585949169375825307419010747907087102529693988502714663897293527240363734284937813181135000995192664742291904645171438423695200374401117403", 2412));
		System.out.println(findMod("43535321", 47));
	}

	public static int findMod(String A, int B) {

		int returnValue = 0;
		int counter = A.length() - 1;

		int tenModulo = 1 % B;


		while (counter >= 0) {

			returnValue = (returnValue + (Character.getNumericValue(A.charAt(counter)) * tenModulo) % B) % B;

			tenModulo = tenModulo * 10 % B;

			counter--;
		}
		return returnValue;
	}
}
