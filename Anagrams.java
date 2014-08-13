public class Anagrams {
    public List<String> anagrams(String[] strs) {
        ArrayList<String> ret = new ArrayList<String> ();
        if(strs == null || strs.length ==0) return ret;
        
        HashMap<String, ArrayList<String>> temp = new HashMap<String, ArrayList<String>>();
        
        for( int i=0; i<strs.length; i++) {
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String key = new String(str);
            if(temp.containsKey(key)) {
                temp.get(key).add(strs[i]);
            } else {
                ArrayList<String> stringList = new ArrayList<String> ();
                stringList.add(strs[i]);
                temp.put(key, stringList);
            }
        }
        
        Iterator<ArrayList<String>> it = temp.values().iterator();
        
        while(it.hasNext()) {
            ArrayList<String> stringList = it.next();
            if(stringList.size()>1)
                ret.addAll(stringList);
        }
        
        return ret;
        
        
    }
}