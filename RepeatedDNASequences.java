public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new LinkedList<String>();
        if(s==null||s.length()<10) return ret;
        HashSet<Integer> hs = new HashSet<Integer>();
        boolean[] hashRec = new boolean[1<<20];
        int temp = 0;
        for(int i=0;i<9;i++){
            char c=s.charAt(i);
            
            temp<<=2;
            temp = temp|convert(c);
            temp = temp & ((1<<20)-1);
        }
        
        for(int i=9;i<s.length();i++) {
             char c=s.charAt(i);
            temp<<=2;
            temp = temp|convert(c);
            temp = temp & ((1<<20)-1);
            
            if(hashRec[temp]){
                if(!hs.contains(temp)){
                    hs.add(temp);
                    ret.add(s.substring(i-9,i+1));
                }
            } else {
                hashRec[temp] = true;
            }
        }
        
        return ret;
        
        
        
    }
    
    private int convert(char c) {
        int i=0;
        switch(c) {
            case 'A':
                i=0;
                break;
            case 'C':
                i=1;
                break;
            case 'G':
                i=2;
                break;
            case 'T':
                i=3;
                break;
        }
        
        return i;
    }
}
