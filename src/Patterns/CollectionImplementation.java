package Patterns;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Set;;


public class CollectionImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedHashMap<String,Integer> hashmpa = new LinkedHashMap<>();
	hashmpa.put(null, 1);
	hashmpa.put("R", 2);
	hashmpa.put("ramu", 3);
		System.out.println(hashmpa);
		Set<String> keys= hashmpa.keySet();
		
		for(String  key :keys)
		{
			System.out.println(hashmpa.get(key));
		}
		
		
		Set<Entry<String,Integer>> mpkeys = hashmpa.entrySet();

		for(Entry<String,Integer>  mpkey :mpkeys)
		{
			System.out.println(mpkey.getKey() +"-----"+mpkey.getValue());
	}
	}

}
