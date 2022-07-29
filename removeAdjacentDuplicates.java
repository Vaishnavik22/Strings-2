/*
Problem: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
*/

class Solution {
    public String removeDuplicates(String s) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); ++i) {
            // System.out.println("result before: " + result.toString());
            if (result.length() == 0) {
                result.append(s.charAt(i));
            } else {
                if (s.charAt(i) == result.charAt(result.length() - 1)) {
                    result.setLength(result.length() - 1);
                } else {
                    result.append(s.charAt(i));
                }
            }
            // System.out.println("result after: " + result.toString());
        }
        return result.toString();
    }
}