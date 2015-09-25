package com.demo;

public class GridTraversal {

	private static int dim;
	public static void main(String[] args) {
		dim = 4;
		char [] path = new char[dim*2];
		generatePath(0, 0, 0, path);
	}

	private static void generatePath(int x, int y, int i, char[] path) {
		if (x==dim || y==dim) {
			System.out.println(path);
			return;
		}
		path[i] = 'r';
		generatePath(x+1, y, i+1, path);
		path[i] = 'd';
		generatePath(x, y+1, i+1, path);
	}

}
