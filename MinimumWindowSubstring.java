public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        if(T == null || T.length() ==0) return "";
        if(S == null || S.length() ==0) return "";
        String ret = "";
        int len = S.length() + 1;
        int lens = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        HashMap<Character, Integer> mapForCheck = new HashMap<Character, Integer>();
        for(int i=0; i<T.length(); i++) {
            char c = T.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) +1);
                mapForCheck.put(c, mapForCheck.get(c) +1);
            } else {
                map.put(c, 1);
                mapForCheck.put(c,1);
            }
        }
        
        int start = 0, end = -1;
        
        
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if(map.containsKey(c)) {
                    mapForCheck.put(c, mapForCheck.get(c) - 1);
                    if(mapForCheck.get(c)>=0) lens ++;
                    while(lens == T.length()) {
                        char add = S.charAt(start);
                        if(map.containsKey(add)) {
                            mapForCheck.put(add, mapForCheck.get(add) +1);
                            if(mapForCheck.get(add) >0) {
                                if(i-start+1<len) {
                                    len = i-start+1;
                                    ret = S.substring(start, i+1);
                                }
                                lens--;
                            }
                        }
                        start++;
                    }
                }
        }
            return ret;
    }
        
        
        
}