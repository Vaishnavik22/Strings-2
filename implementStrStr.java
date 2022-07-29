/*
Problem: https://leetcode.com/problems/implement-strstr/
*/

// Approach 1: Brute force
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        
        int n = haystack.length();
        int m = needle.length();
        int i = 0;
        
        while (i <= n - m) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 0;
                int k = i;
                
                while (k < n && j < m && haystack.charAt(k) == needle.charAt(j)) {
                    ++j;
                    ++k;
                }
                
                if (j == m) {
                    return i;
                }
            }
            ++i;
        }
        return -1;
    }
}

// Approach 2: KMP algorithm
// TODO