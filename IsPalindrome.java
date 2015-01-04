
public class IsPalindrome {
	public boolean isPalindrome(String s) {
        if(s==null || s.length()<=1) return true;
        s = s.toLowerCase();
        int r = s.length()-1;
        int l = 0;
        while(l<r) {
            while(l<r && (s.charAt(l)<'a'||s.charAt(l)>'z') && (s.charAt(l)<0 || s.charAt(l)>9)) l++;
            while(l<r && (s.charAt(r)<'a'||s.charAt(r)>'z') && (s.charAt(r)<0 || s.charAt(r)>9)) r--;
            
            if(s.charAt(l) != s.charAt(r)) return false;
            
            l++;
            r--;
        }
        
        return true;
        
    }
	 
	 public static void main(String[] args) {
		IsPalindrome isp = new IsPalindrome();
		
		String test = "1a2";
		System.out.println('Z'-'z');
		System.out.println(isp.isPalindrome(test));
	}
}
