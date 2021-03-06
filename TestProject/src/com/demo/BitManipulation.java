package com.demo;

public class BitManipulation {

	public static void main(String[] args) {
		udpateBits(8, 2, 1, 2);
		System.out.println(~(1 << 2));
	}

	private static void udpateBits(int n, int m, int i, int j) {
		int max = ~0;
		int left = max - ((1<<j) - 1);
		int right = ((1<<i) - 1);
		int mask = left | right;
		System.out.println(max + ":" + left + ";" + right);
		System.out.println((n & mask) | (m<<i));
		
	}

}
