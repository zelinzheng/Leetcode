import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FindSubstring {
	public static List<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> ret  = new ArrayList<Integer>();
        
        if(S==null|| L == null || L.length == 0) return ret;
        int length = L[0].length();
        if(S.length() < length*L.length) return ret;
        
        HashMap<String, Integer> ls = new HashMap<String, Integer>();
        
        for(String s:L) {
            if(!ls.containsKey(s)) 
                ls.put(s, 1);
            else 
                ls.put(s, ls.get(s)+1);
        }
        System.out.println(ls);
        HashMap<String, Integer> ss = new HashMap<String, Integer>();
        for(int i=0; i<length; i++) {
            int begin = i;
            int count = 0;
            ss.clear();
            for(int j=i; j+length<=S.length(); j+=length) {
                String temp = S.substring(j, j+length);
                if(ls.containsKey(temp)) {
                    if(!ss.containsKey(temp)){ ss.put(temp, 1);
                        count++;
                    } else if(ss.get(temp)<ls.get(temp)){
                        ss.put(temp, ss.get(temp)+1);
                        count++;
                    } else {
                        String delete = null; 
                        while(!((delete = S.substring(begin, begin+length)).equals(temp))) {
                            begin = begin + length;
                            ss.put(delete, ss.get(delete)-1);
                            count--;
                        }
                        begin = begin + length;
                    }
                    if(count == L.length)
                        ret.add(begin);
                        
                } else {
                    ss.clear();
                    count = 0;
                    begin = j + length;
                }
            }
        }
        
        return ret;
        
    }
	
	public static void main(String[] args) {
		String S = "abaababbaba";
		String[] L = {"ab","ba","ab","ba"};
		
		System.out.println(FindSubstring.findSubstring(S, L));
	}
}
