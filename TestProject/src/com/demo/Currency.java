package com.demo;

public class Currency {

	private static int[] currency = new int[4];
	private static int[] result = new int[] {0, 0, 0, 0};
	public static void main(String[] args) {
		currency[0] = 25;
		currency[1] = 10;
		currency[2] = 5;
		currency[3] = 1;
		findCombinations(50, 0);
	}

	private static void findCombinations(int total, int curIndx) {
		while (totalAmount() < total) {
			if (curIndx < 3) {
			    findCombinations(total, curIndx + 1);
			}
	        result[curIndx]++;
		}
		if (totalAmount() == total) {
			System.out.println(result[0] + "," + result[1] + "," + result[2] + "," + result[3]);
		}
		result[curIndx] = 0;
	}

	private static int totalAmount() {
		int totalA =0;
		for (int i=0;i<4;i++) {
			totalA += currency[i] * result[i];
		}
		return totalA;
	} 
}
