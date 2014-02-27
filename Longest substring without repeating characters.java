


Longest Substring Without Repeating Characters Total Accepted: 8592 Total Submissions: 37725My Submissions




Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.


Firstly, I came up with the straight solution as below:

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length() ==0) return 0;
        int max = 0;
        Set<Character> set = new HashSet<Character>();
        for(int i=0; i<s.length(); i++) {
            if(!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                if(set.size()>max) max = set.size();
            } else
                set.clear();
        }
       
        return max;
       
       
    }
}

However, this doesn’t pass the test. It is because I am missing lots of test cases. For example:
     In a string like “abcdae”, my algorithm would give a result as 4 instead of 5. I missed to test the case beginning between the first a and the second a.
     Therefore, to solve this case, I add another level of loop to test all the cases beginning at each position.

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length() ==0) return 0;
        int max = 0;
        Set<Character> set = new HashSet<Character>();
        for(int i=0; i<s.length(); i++) {
            set.clear();
            for(int j=i;j<s.length();j++) {
                if(!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    //Mark
                } else { 
                    if(set.size()>max) max = set.size(); // if
                    break;
                }
            }
        }
        
        return max;
        
        
    }
}

Take care, this is a wrong answer because it fail to test the size of the set if the longest substring ends up in the tail of the string. That is to say, the algorithm can not find an opportunity to step inside the else situation so as to compare the size of the set and the max value. This can be fixed by moving the if statement into the “Mark” position.

However, this is a very stupid algorithm, and actually we don’t have to test the substring beginning at each position. Think about the position of the repeating character within the substring, the beginning before this position won’t get a better result. Therefore we can jump to the position after it.

public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length() ==0) return 0;
        int max = 0;
        int[] index = new int[256];
        int begin = 0;
        for(int i:index) i=-1;
        for(int i=0; i<s.length(); i++) {
            begin = Math.max(begin, index[s.charAt(i)]);
                index[s.charAt(i)] = i+1;
                max = Math.max(max, i-begin+1);

        }
        
        
        return max;    
    }

Check out this algorithm, it is pretty elegant and concise, which I found in the discuss leetcode.
