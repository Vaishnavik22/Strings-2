/*
Problem: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
*/


// Approach 1
// TC: O(n)
// SC: O(n)
class Pair {
    char ch;
    int freq;
    
    public Pair(char c, int f) {
        this.ch = c;
        this.freq = f;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            
            if (!st.isEmpty() && st.peek().ch == ch) {
                if (st.peek().freq == k - 1) {
                    st.pop();
                } else {
                    ++st.peek().freq;
                }
            } else {
                st.push(new Pair(ch, 1));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!st.isEmpty()) {
            Pair p = st.pop();
            for (int i = 0; i < p.freq; ++i) {
                sb.insert(0, p.ch);
            }
        }
        
        return sb.toString();
    }
}


// Aproach 2
// TC: O(n^2) because of the delete operation which would probably require a copy of the characters under consideration.
// SC: O(n)
class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int count[] = new int[sb.length()];
        
        for(int i = 0; i < sb.length(); ++i) {
            if(i == 0 || sb.charAt(i) != sb.charAt(i-1)) {
             count[i] = 1;   
            } else {
                count[i] = count[i-1] + 1;
                if(count[i] == k) {
                    sb.delete(i-k+1, i+1);
                    i = i-k;
                }
            }
        }
        
        return sb.toString();
    }
}