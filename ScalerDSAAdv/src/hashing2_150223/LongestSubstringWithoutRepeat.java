package hashing2_150223;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeat {

	public int lengthOfLongestSubstring(String A) { // not working
		int min = Integer.MIN_VALUE;
		int res = 0;
		HashSet<Character> hs = new HashSet<>();
		// only workng if no duplicates and unique sequence at start
		for(int i=0; i<A.length(); i++) {
			hs.add(A.charAt(i));
			int len = hs.size();
			if(len == (i+1)) res = len;
			
			min = Math.max(res, min);
		}
		return min;
    }
	public int lengthOfLongestSubstringBrute(String A) { // O(N3) error for some
		// generate substrings
		int min = Integer.MIN_VALUE;
		if(A.length()==1) return 1;
		for(int i=0; i<A.length(); i++) {
			for(int j=i+1; j<A.length(); j++) {
				String temp = A.substring(i, j);
				// check if substrings have unique character using HashSet
				HashSet<Character> hs = new HashSet<>();
				for(int k=0; k<temp.length(); k++) {
					hs.add(temp.charAt(k));
					min = Math.max(min, hs.size());
				}
				//System.out.println(temp + " "+ min);
			}
		}
		// output the longest HashSet with 
		return min;
    }
	public int lengthOfLongestSubstring2(String A) { // O(N2) error for some
		// generate substrings
		int min = Integer.MIN_VALUE;
		int l=0, r=0;
		if(A.length()==1) return 1;
		while(l<A.length()) {
			HashSet<Character> hs = new HashSet<>();
			for(r=0; r<A.length(); r++) {
				hs.add(A.charAt(r));
				if(hs.size() != (r-1+1)) {
					l++;
					continue;
				}
				else {
					min = Math.max(min, hs.size());
					l++;
				}
			}
		}
		// output the longest HashSet with 
		return min;
	}
	public int lengthOfLongestSubstringLinear(String A) { // O(N) --working
		// generate substrings
		int min = Integer.MIN_VALUE;
		int l=0, r=0;
		if(A.length()==1) return 1;
		HashSet<Character> hs = new HashSet<>();
		while(r<A.length()) {
			if(!hs.contains(A.charAt(r))) {
				hs.add(A.charAt(r));
				r++;
				min = Math.max(min, hs.size());
			}
			else {
				hs.remove(A.charAt(l));
				l++;
				
			}
		}
		return min;
	}
	public int lengthOfLongestSubstringScalersol(String A) {
        int count = 0;
        int max = 0;
        int n = A.length();
        HashMap < Character, Integer > hashMap = new HashMap < > ();
        char c;
        int prevIndex;
        for (int i = 0; i < n; i++) {
            c = A.charAt(i);
            // hashMap stores the last occurrence of c in A
            if (hashMap.containsKey(c)) {
                prevIndex = hashMap.get(c);
                count = Math.min(count + 1, i - prevIndex);
                hashMap.put(c, i);
            } else {
                count++;
                hashMap.put(c, i);
            }
            max = Math.max(max, count);
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeat lswr = new LongestSubstringWithoutRepeat();
		System.out.println(lswr.lengthOfLongestSubstring("abcabcbb")); // 3
		System.out.println(lswr.lengthOfLongestSubstring("AaaA")); //2
		System.out.println(lswr.lengthOfLongestSubstringBrute("aabcabcbb")); // 3
		System.out.println(lswr.lengthOfLongestSubstringBrute("AaaA")); // 2
		System.out.println(lswr.lengthOfLongestSubstring2("aabcabcbb")); // 3
		System.out.println(lswr.lengthOfLongestSubstring2("AaaA")); // 2
		System.out.println(lswr.lengthOfLongestSubstring2("aabcabcbb")); // 3
		System.out.println(lswr.lengthOfLongestSubstringLinear("aabcabcbb")); // 3
		System.out.println(lswr.lengthOfLongestSubstringLinear("AaaA")); // 2
		System.out.println(lswr.lengthOfLongestSubstringLinear("aabcabcbb")); // 3
		System.out.println(lswr.lengthOfLongestSubstringLinear("u")); //1
		System.out.println(lswr.lengthOfLongestSubstringBrute("u")); // 1
		System.out.println(lswr.lengthOfLongestSubstring2("u")); // 1
		System.out.println(lswr.lengthOfLongestSubstringLinear("dadbc")); //4
		System.out.println(lswr.lengthOfLongestSubstringBrute("dadbc")); //  3 --4
		System.out.println(lswr.lengthOfLongestSubstring2("dadbc")); //  4
		String A = "Wnb9z9dMc7E8v1RTUaZPoDNIAXRlzkqLaa97KMWLzbitaCkRpiE4J4hJWhRcGnC8H6mwasgDfZ76VKdXhvEYmYrZY4Cfmf4HoSlchYWFEb1xllGKyEEmZOLPh1V6RuM7Mxd7xK72aNrWS4MEaUmgEn7L4rW3o14Nq9l2EN4HH6uJWljI8a5irvuODHY7A7ku4PJY2anSWnfJJE1w8p12Ks3oZRxAF3atqGBlzVQ0gltOwYmeynttUmQ4QBDLDrS4zn4VRZLosOITo4JlIqPD6t4NjhHThOjJxpMp9fICkrgJeGiDAwsb8a3I7Txz5BBKV9bEfMsKNhCuY3W0ZHqY0MhBfz1CbYCzwZZdM4p65ppP9s5QJcfjadmMMi26JKz0TVVwvNA8LP5Vi1QsxId4SI19jfcUH97wmZu0pbw1zFtyJ8GAp5yjjQTzFIboC1iRzklnOJzJld9TMaxqvBNBJKIyDjWrdfLOY8FGMOcPhfJ97Dph35zfxYyUf4DIqFi94lm9J0skYqGz9JT0kiAABQZDazZcNi80dSSdveSl6h3dJjHmlK8qHIlDsqFd5FMhlEirax8WA0v3NDPT8vPhwKpxcnVeu14Gcxr3h1wAXXV0y7Xy9qqB2NQ5HQLJ7cyXAckEYHsLCPSy28xcdNJatx1KLWohOQado4WywJbGvsFR17rKmvOPABweXnFD3odrbSMD4Na4nuBBswvMmFRTUOcf7jZi4z5JnJqXz6hitaPnaEtjoSEBq82a52nvqYy7hhldBoxen2et2OMadVEHeTYLL7GLsIhTP6UizHIuzcJMljo4lFgW5AyrfUlIBPAlhwaSiJtTvcbVZynDSM6RO1PqFKWKg2MHIgNhjuzENg2oFCfW7z5KJvEL9qWqKzZNc0o3BMRjS04NCHFvhtsteQoQRgz84XZBHBJRdekCdcVVXu9c01gYRAz7oIAxN3zKZb64EFKssfQ4HW971jv3H7x5E9dAszA0HrKTONyZDGYtHWt4QLhNsIs8mo4AIN7ecFKewyvGECAnaJpDn1MTTS4yTgZnm6N6qnmfjVt6ZU51F9BxH0jVG0kovTGSjTUkmb1mRTLQE5mTlVHcEz3yBOh4WiFFJjKJdi1HBIBaDL4r45HzaBvmYJPlWIomkqKEmQ4rLAbYG7C5rFfpMu8rHvjU7hP0JVvteGtaGn7mqeKsn7CgrJX1tb8t0ldaS3iUy8SEKAo5IZHNKOfEaij3nI4oRVzeVOZsH91pMsA4jRYgEohubPW8ciXwVrFi1qEWjvB8gfalyP60n1fHyjsiLW0T5uY1JzQWHKCbLVh7QFoJFAEV0L516XmzIo556yRH1vhPnceOCjebqgsmO78AQ8Ir2d4pHFFHAGB9lESn3OtJye1Lcyq9D6X93UakA3JKVKEt6JZDLVBMp4msOefkPKSw59Uix9d9kOQm8WCepJTangdNSOKaxblZDNJ5eHvEroYacBhd9UdafEitdF3nfStF7AhkSfQVC61YWWkKTNdx96OoJGTnxuqt4oFZNFtO7aMuN3IJAkw3m3kgZFRGyd3D3wweagNL9XlYtvZwejbjpkDOZz33C0jbEWaMEaUPw6BG49XqyQoUwtriguO0yvWyaJqD4ye3o0E46huKYAsdKAq6MLWMxF6tfyPVaoqOGd0eOBHbAF89XXmDd4AIkoFPXkAOW8hln5nXnIWP6RBbfEkPPbxoToMbV";
		System.out.println(lswr.lengthOfLongestSubstringLinear(A)); // 22 -- 27
		System.out.println(lswr.lengthOfLongestSubstringBrute(A)); //  62 -- 27
		System.out.println(lswr.lengthOfLongestSubstring2(A)); //  27
	}

}
