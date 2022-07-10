package com.sample.project.stringoperations;

public class BinaryStringSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("1", "1"));
	}

	public static String addBinary(String A, String B) {

		String returnValue = "";

		char cBit = '0';

		while (A.length() > 0 || B.length() > 0) {

			//System.out.println(A+ " ** " + B);
			char bBit = '0', aBit = '0';

			if (A.length() > 0) {

				aBit = A.charAt(A.length() - 1);
				A = A.substring(0, A.length() - 1);

			} else {
				aBit = '0';
			}
			if (B.length() > 0) {
				bBit = B.charAt(B.length() - 1);
				B = B.substring(0, B.length() - 1);
			} else {
				bBit = '0';
			}
			
			

			if ((Integer.parseInt(aBit + "") + Integer.parseInt(bBit + "") + Integer.parseInt(cBit + "")) < 2) {

				returnValue = (Integer.parseInt(aBit + "") + Integer.parseInt(bBit + "")+ Integer.parseInt(cBit + "")) + "" + returnValue;
				cBit = '0';

			} else {

				returnValue = String.valueOf((Integer.parseInt(aBit + "") + Integer.parseInt(bBit + "")+ Integer.parseInt(cBit + "")) % 2) + ""
						+ returnValue;

				//System.out.println(((Integer.parseInt(aBit + "") + Integer.parseInt(bBit + "")) / 2));
				cBit = String.valueOf((Integer.parseInt(aBit + "") + Integer.parseInt(bBit + "")+ Integer.parseInt(cBit + "")) / 2).charAt(0);
				
			}
		}

		//System.out.println(cBit + "  *** " + returnValue);

		while (Integer.parseInt(String.valueOf(cBit)) > 0) {

			returnValue = (Integer.parseInt(String.valueOf(cBit)) % 2) + "" + returnValue;

			cBit = String.valueOf((Integer.parseInt(String.valueOf(cBit))) / 2).charAt(0);

		}

		return returnValue;

	}

}
