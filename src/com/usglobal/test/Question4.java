package com.usglobal.test;

public class Question4 {

	public static void largestInColumn(int cols, int[][] arr) {
		for (int i = 0; i < cols; i++) {

			int max = arr[0][i];
			for (int j = 1; j < arr[i].length; j++)
				if (arr[j][i] > max)
					max = arr[j][i];

			System.out.println("max value in column "+i+" is "+max);
		}
	}
	public static void smallestInColumn(int cols, int[][] arr) {

		for (int i = 0; i < cols; i++) {

			int min = arr[0][i];
			for (int j = 1; j < arr[i].length; j++)
				if (arr[j][i] < min)
					min = arr[j][i];

			System.out.println("min value in column "+i+" is "+min);
		}
	}

	public static void largestInRow(int rows, int[][] arr) {
		for (int i = 0; i < rows; i++) {

			int max = arr[0][i];
			for (int j = 1; j < arr[i].length; j++)
				if (arr[i][j] > max)
					max = arr[i][j];

			System.out.println("max value in row "+i+" is "+max);
		}
	}
	
	public static void smallaestInRow(int rows, int[][] arr) {
		for (int i = 0; i < rows; i++) {

			int min = arr[0][i];
			for (int j = 1; j < arr[i].length; j++)
				if (arr[i][j] < min)
					min = arr[i][j];

			System.out.println("min value in row "+i+" is "+min);
		}
	}
	// Driver code
	public static void main(String[] args) {
		int[][] arr = new int[][] { { 3, 2,	4, 2, 2, 4 }, 
			{ 9, 3,	3,	6,	1,	2 },
			{ 5, 5,	3,	7,	2,	4 }, 
			{ 1, 9,	4,	2,	8,	9 },
			{ 4, 6,	4,	1,	6,	6 },
			{ 1, 7, 6,	1,  4,  1 }};
		// Calling the function
		
			smallestInColumn(6, arr);
		
	}

}
