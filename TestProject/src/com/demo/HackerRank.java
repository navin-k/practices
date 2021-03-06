package com.demo;

public class HackerRank {

	public static void main(String[] args) {
        String s = "dhck";
        String copy = new String(s);
        char[] charArray = s.toCharArray();
        int pivot = findPivot(charArray);
        System.out.println("Pivot:" + pivot );
        if (pivot == -1) {
        	System.out.println("No answer");
        	return;
        }
        int next = findNext(charArray, pivot);
        
        System.out.println("Pivot:" + pivot + ":Next:" + next);
        charArray[pivot] = (char)((int)charArray[pivot] + (int)charArray[next]);
        charArray[next] = (char)((int)charArray[pivot] - (int)charArray[next]);
        charArray[pivot] = (char)((int)charArray[pivot] - (int)charArray[next]);
        System.out.println("After swap:" + new String(charArray));
        
        sortRest(charArray, pivot);
        if (!copy.equalsIgnoreCase(new String(charArray))) {
        	System.out.println("Got it:" + new String(charArray));
        } else {
        	System.out.println("No answer");
        }

    }

	private static void sortRest(char[] charArray, int pivot) {
		for (int i=pivot+1 ; i< charArray.length ; i++) {
			for (int j=pivot+1 ; j<charArray.length - 1 ; j++) {
				if (charArray[j] > charArray[j+1]) {
			        charArray[j] = (char)((int)charArray[j] + (int)charArray[j+1]);
			        charArray[j+1] = (char)((int)charArray[j] - (int)charArray[j+1]);
			        charArray[j] = (char)((int)charArray[j] - (int)charArray[j+1]);					
				}
			}
		}
		
	}

	private static int findNext(char[] charArray, int c) {
		int idx = -1;
		char ch = charArray[c];
		for(int i=c ; i< charArray.length ; i++) {
			if ((charArray[i] > ch) && ((idx == -1) || (charArray[idx] > charArray[i]))){
				idx = i;
			}
		}
		return idx;
	}

	private static int findPivot(char[] charArray) {
		int i = 0;
		for(i=charArray.length-2 ; i>=0 ; i--) {
			if (charArray[i] < charArray[i+1])
				break;
		} 
		return i;
	}

}
