import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	public static void main(String[] args) {
		// "red", "tax", ["ted","tex","red","tax","tad","den","rex","pee"]
		// "hot", "dog", ["hot","cog","dog","tot","hog","hop","pot","dot"]
		//"lost", "cost", ["most","fist","lost","cost","fish"]

		String start = "lost";
		String end = "cost";
		HashSet<String> dict = new HashSet<String>();
		// dict.add("ted");
		// dict.add("tex");
		// dict.add("red");
		// dict.add("tax");
		// dict.add("tad");
		// dict.add("den");
		// dict.add("rex");
		// dict.add("pee");
		dict.add("most");
		dict.add("first");
		dict.add("lost");
		dict.add("cost");
		dict.add("fish");
		//dict.add("hop");

		System.out.println(findLadders(start, end, dict));

	}

	public static List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		List<List<String>> ret = new LinkedList<List<String>> ();
        HashMap<String, List<String>> preMap = new HashMap<String, List<String>> ();

        Queue<String> ql = new LinkedList<String>();
        ql.offer(start);
        if(dict.contains(start)) dict.remove(start);
        
        int presize = 0;
        int cursize = 1;
        while(ql.size() !=0) {
            int tempsize = presize;
            presize = cursize;
            cursize = tempsize;
            List<String> usedString = new LinkedList<String>();
            
            while(presize>0){
            
            String temp = ql.poll();
            if(temp.equals(end)) break;
                
            for(int i=0; i<temp.length(); i++) {
                char[] tempChars = temp.toCharArray();
                char flag = tempChars[i];
                    
                for(char c = 'a';c<='z'; c++) {
                    if(c==flag) continue;
                    tempChars[i] = c;
                    String newtemp = new String(tempChars);
                        
                    if(dict.contains(newtemp)) {
                        usedString.add(newtemp);
                            
                        if(preMap.containsKey(newtemp)) {
                            preMap.get(newtemp).add(temp);
                        } else {
                            List<String> tempListString = new LinkedList<String>();
                            tempListString.add(temp);
                            preMap.put(newtemp, tempListString);
                        }
                            
                        ql.offer(newtemp);
                        cursize++;
                    }
                }
             }
             
             presize--;
            }
            for(String string:usedString) {
                dict.remove(string);
            }
            
        }
        
        
        List<String> path = new LinkedList<String>();
        generatePath(ret, preMap, start,end, path);
        
        return ret;
	}

	private static void generatePath(List<List<String>> ret,
			HashMap<String, List<String>> preMap, String start, String word,
			List<String> path) {
		path.add(0, word);
		if (word.equals(start)) {
			ret.add(path);
			return;
		}
		if (preMap.containsKey(word)) {
			for (String string : preMap.get(word)) {
				List<String> newPath = new LinkedList<String>(path);
				generatePath(ret, preMap, start, string, newPath);
			}
		}
	}
}
