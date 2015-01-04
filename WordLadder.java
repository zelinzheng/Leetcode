import java.util.HashSet;
import java.util.Set;


public class WordLadder {
	
	public static void main(String[] args) {
		String start = "hot";
		String end = "dog";
		
		Set<String> set = new HashSet<String> ();
		set.add("hot");
		set.add("dog");
		set.add("dot");
		
		System.out.println(new WordLadder().ladderLength(start,end, set));
		
	}
	public int ladderLength(String start, String end, Set<String> dict) {
        int steps = search(start, end, dict);
        return steps==0?0:1+steps;
    }
    
    public int search(String start, String end, Set<String> dict) {
        
        int ret = 0;
        for(int i=0; i<start.length(); i++) {
            if(start.charAt(i)!= end.charAt(i)) {
                char[] newS = start.toCharArray();
                newS[i] = end.charAt(i);
                String newStart = new String(newS);
                
                if(newStart.equals(end)) return 1;
                if(dict.contains(newStart)) {
                    int steps = ladderLength(newStart, end, dict);
                    if(ret==0 || (steps!=0 && steps<ret)) ret = steps;
                }
            } else {
                continue;
            }
        }
        return ret==0? ret:ret+1;
    }
}
