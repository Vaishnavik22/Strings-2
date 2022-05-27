/*
Problem: https://leetcode.com/problems/find-all-anagrams-in-a-string/
TC: O(n + m) where n = length(s), m = length(p)
if m > n, we won't get an anagram
SC: O(1) - map only contains 26 characters
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> result = new ArrayList<>();
        
        if (m > n) {
            return result;
        }
        
        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        
        for (Character c : p.toCharArray()) {
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
        }
        
        int matches = 0;
        int windowStart = 0, windowEnd = 0;
        for (windowEnd = 0; windowEnd < n; ++windowEnd) {
            char c = s.charAt(windowEnd);
            
            if (charFreqMap.containsKey(c)) {
                charFreqMap.put(c, charFreqMap.get(c) - 1);

                if (charFreqMap.get(c) == 0) {
                    ++matches;
                }
            }

            if (matches == charFreqMap.size()) {
                result.add(windowStart);
            }
            
            if (windowEnd >= m - 1) {
                char outgoing = s.charAt(windowStart);
                
                if (charFreqMap.containsKey(outgoing)) {
                    charFreqMap.put(outgoing, charFreqMap.get(outgoing) + 1);

                    if (charFreqMap.get(outgoing) == 1) {
                        --matches;
                    }
                }
                ++windowStart;
            }
        }
        
        return result;
    }
}