package Patterns;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class HashMapClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		HashMap<String ,Integer> h = new HashMap<String,Integer>();
		h.put("Ani", 8);
		h.put("Ani", 6);
		h.put("Luh", 10);
		h.put("Rag", 20);
		h.put("Rag", 19);
		h.put("Rag", 18);
		h.put("ABC", 18);
		h.put("ADC", 18);
		h.put("ABE", 18);
		
		System.out.println(h);
		
		
		List<String> keys = new LinkedList<String>(h.keySet());
		List<Integer> values = new LinkedList<Integer>(h.values());
		
		System.out.println(keys);
		System.out.println(values);
		
		
		
		
		
		

	}

}
