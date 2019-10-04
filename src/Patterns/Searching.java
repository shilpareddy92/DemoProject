package Patterns;

import java.util.Map;

public class Searching {

	
	
	
	public static int SearchandSort(int[] numbers,int key)
	{
		
		int low= 0;
		int high = numbers.length-1;
		
		while(low <= high)
		{
			int mid =  (low+high)/2;
			if(numbers[mid]==key)
			{
				return mid;
			}
			if(key<numbers[mid])
			{
				high=  mid-1;
			}
			else
			{
				low=  mid+1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] numbers = {1,10,20,47,59,65,75,88,99};
		System.out.println(SearchandSort(numbers,99));
	}

}
