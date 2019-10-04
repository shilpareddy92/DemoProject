package Patterns;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static   int[] twosum(int[] numbers,int target)
	{
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (!map.containsKey(target - numbers[i])) {
				map.put(numbers[i], i);
			} else {
				result[1] = 0;
				result[0] =  map.get(target - numbers[i]);
				return result;
			}
		}
		
		
		throw new IllegalArgumentException("two numbers not found");
	}

	public static void main(String[] args) {
		
		int[] numbers = {2,5,7,9,4};
		int[] results = twosum(numbers,9);
	}

}
