package com.demo;

public class DemoClass {

	public static int counter;
	public static void main(String[] args) {
		String string = "abcde";
		char[] str = string.toCharArray();
		counter = 0;
		permutate(0, str);
		System.out.println("Counter is: " + counter);
	}
	private static void permutate(int pivot, char[] str) {
		if (pivot == str.length) {
			System.out.println(new String(str));
			counter++;
			return;
		}
		for (int i = pivot; i < str.length ; i++) {
			swap(str, pivot, i);
			permutate(pivot + 1, str);
			swap(str, pivot, i);
		}
	}
	private static void swap(char[] str, int pivot, int i) {
		char temp = str[pivot];
		str[pivot] = str[i];
		str[i] = temp;
	}

	private static int getAbsoluteValue(int i) {
        return (i < 0) ? i * -1: i;
    }
}
