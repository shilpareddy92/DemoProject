package Patterns;

import java.util.Scanner;

public class PrintPrime {

	public static void main(String[] args) {
		
		int array[] = new int[3];
		Scanner s= new Scanner(System.in);
		
		for(int i=0;i<array.length;i++)
		{
			array[i] = s.nextInt();
		}
		
		System.out.println(array.length);
		s.close();
		int min= 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i; j < array.length-1; j++) {

				if (array[j] < array[i]) {
					min = array[j];
				}

			}
		}
		System.out.println(min);
	}

}
