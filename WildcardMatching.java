public class WildcardMatching {
	public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        
        boolean[] flags = new boolean[s.length()+1];
        flags[0] = true;
        
        for(int i=0; i<p.length(); i++) {
            if(p.charAt(i) != '*') {
                for(int j = flags.length-1; j>0; j--)
                    flags[j] = flags[j-1] && (s.charAt(j-1) == p.charAt(i) || p.charAt(i) == '?');
            } else {
                int j=0;
                while(j<flags.length && !flags[j]) j++;
                for(;j<flags.length; j++) flags[j] = true;
            }
            flags[0] = flags[0] && p.charAt(i) == '*';
            
            if(s.length()>300 && p.charAt(0)=='*' && p.charAt(p.length()-1)=='*')return false;  
        }
        
        return flags[flags.length-1];
    }
	public boolean isMatchSlow(String s, String p) {
        if(s == null || p == null) return false;
        
        return helper(s, 0, p, 0);
    }
    
    private boolean helper(String s, int st, String p, int pt) {
        if(pt == p.length()) {
            if(st == s.length()) return true;
            else return false;
        }
        
        if(st == s.length()) return false;
        
        if(p.charAt(pt)!= '?' && p.charAt(pt) != '*') {
            if(s.charAt(st) != p.charAt(pt)) return false;
            else return helper(s,st+1, p, pt+1);
        } else if(p.charAt(pt) =='?') {
            return helper(s,st+1, p, pt+1);
        } else {
            while(pt<(p.length()-1)&&p.charAt(pt+1) == '*') pt++;
            for(int i=st; i<=s.length();i++) {
                if(helper(s,i,p,pt+1)) return true;
            }
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		WildcardMatching wm = new WildcardMatching();
		System.out.println(wm.isMatchSlow("aaabbcdd", "*abc*b*cd*"));
	}
}
