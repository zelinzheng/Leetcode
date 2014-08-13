public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() ==0) return 0;
        
        int last = -1;
        int max = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if(stack.isEmpty())
                    last = i;
                else {
                    stack.pop();
                    if(stack.isEmpty()) 
                        max = Math.max(i-last, max);
                    else {
                        max = Math.max(i-stack.peek(), max);
                    } 
                }
            }
        }
        
        return max;
    }
}