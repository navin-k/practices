package com.demo;

import java.util.StringTokenizer;

public class WildCards {

	public static void main(String[] args) {
		String wc = "c*a*t";
		String str = "ccseiwruetat";
		System.out.println(checkTokens(wc, str));
	}

	public static boolean checkTokens(String wc, String str) {
		boolean tokenFound=false;
		for (int i=0 ; i< str.length() ; i++) {
			StringTokenizer tokenizer = new StringTokenizer(wc, "*");
			int nextIndexForToken = i;
			while (tokenizer.hasMoreTokens()) {
				String token = tokenizer.nextToken();
				tokenFound = false;
				for (int j=nextIndexForToken ; j<str.length() ; j++) {
					String substring = new String(str.substring(j, 
							(token.length() + j)));
					if (token.equals(substring)) {
						tokenFound = true;
						nextIndexForToken=j + token.length();
						break;
					}
				}
				if(!tokenFound) {
					return false;
				}
			}
			if(tokenFound) {
				return true;
			}
		}
		return false;
	}

}
