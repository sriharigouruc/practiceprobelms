package com.maang.goal.recursion;

public class RecursionPowerWithMod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(-1 % 20);
		System.out.println(pow(-5, 3, 4));
		System.out.println(pow(71045970, 41535484, 64735492));
	}

	public static int pow(int A, int B, int C) {
		if (B == 0)
			return 1 % C;

		long value = pow(A, B / 2, C);

		long modulo = (value) % C;
		long currentModulo = (modulo * modulo) % C;

		if (B % 2 == 1) {
			return (int) (((currentModulo * A % C) + C) % C);

			// return currentModulo < 0 ? (currentModulo + C) % C : currentModulo;
		}

		else {
			return (int) ((C + currentModulo) % C);
			// return currentModulo < 0 ? (currentModulo + C) % C : currentModulo;
		}

	}
	public static int nonRecursive(int A, int B, int C) {
	
		if (B == 0)
			return 1 % C;

		long value = pow(A, B / 2, C);

		long modulo = (value) % C;
		long currentModulo = (modulo * modulo) % C;

		if (B % 2 == 1) {
			return (int) (((currentModulo * A % C) + C) % C);

			// return currentModulo < 0 ? (currentModulo + C) % C : currentModulo;
		}

		else {
			return (int) ((C + currentModulo) % C);
			// return currentModulo < 0 ? (currentModulo + C) % C : currentModulo;
		}

	}
}
