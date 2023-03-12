package twopointers_100223;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SampleHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<String>();
		set.add("1");
		set.add("13");
		set.add("27");
		set.add("87");
		set.add("19");

		System.out.println("Hash Set Contains :" + set);
		String arr[] = new String[set.size()];

		// toArray() method converts the set to array
		set.toArray(arr);

		for (String n : arr)
			System.out.println(n);

		Map<String, Integer> map = new HashMap<>();
		map.put("apple", 1);
		map.put("banana", 2);
		map.put("cherry", 3);
		map.put("baana", 2);
		map.put("bana", 2);

		int count=0;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			  System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
			  if(entry.getValue()>1) count++;
		}
		System.out.println(count);
	}

}
