package com.usglobal.test;

public class Question1 {

	public static void main(String[] args) {

		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 ) {
				System.out.println("CT");
			}
			else if( i % 5 == 0)
			{
				System.out.println("MR");
			}
			else if  (i % 15 == 0) {
				System.out.println("US");
			} 
			else{
				System.out.println(i);
			}

		}
	}

}
