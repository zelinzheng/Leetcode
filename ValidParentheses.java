public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length()%2 !=0) return false;
        
        Stack<Character> sc = new Stack<Character>();
        for(int i=0;  i<s.length() ;i++) {
            char c = s.charAt(i);
            if( c == '(' || c == '{' || c == '[') {
                sc.push(c);
            } else if ( c == ')') {
                if(sc.empty() || sc.pop() != '(') return false;
            } else if ( c == '}') {
                if(sc.empty() || sc.pop() != '{') return false;
            } else if ( c == ']') {
                if(sc.empty() || sc.pop() != '[') return false;
            }
        }
        
        return sc.empty()? true:false;
        
    }
}