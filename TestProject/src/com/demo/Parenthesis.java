package com.demo;

public class Parenthesis {

	private static int counter;
	public static void main(String[] args) {
		int count = 4;
		generateParenthesis((count*2));
		printPar(count);
	}

	private static void generateParenthesis(int count) {
		counter = 0;
		double upper = Math.pow(2, count);
		double start = Math.pow(2, count - 1);
		for (int i = (int) start; i <= upper;) {
			outputValidPerenthesisCombination(i);
			i = i+2;
		}
	}

	private static void outputValidPerenthesisCombination(int i) {
		StringBuilder builder = new StringBuilder();
		int quot = i;
		int [] braces = new int[2];
		braces[0] = 0;
		braces[1] = 0;
		while (quot > 0) {
			int brace = quot % 2;
			braces[brace] += 1;
			builder.insert(0, brace == 0 ? ")" : "(");
			quot = quot/2;
			if (braces[0] < braces[1])
				return;
		}
		if ((braces[0] == braces[1])) {
			counter++;
		    System.out.println(builder.toString() + ":" + counter);
		}
	}

	public static void printPar(int l, int r, char[] str, int count) {
		if (l<0 || r<l) return;

		if (l==0 && r==0) {
			System.out.println(new String(str) + ":" + counter);
			counter++;
		} else {
			if (l>0) {
				str[count] = '(';
				printPar(l-1, r, str, count + 1);
			}
			if (r>l) {
				str[count] = ')';
				printPar(l, r-1, str, count + 1);
			}
		}
	}
	public static void printPar(int count) {
		counter = 1;
		char[] str = new char[count*2];
		printPar(count, count, str, 0);
	}
}
