public class CompareVersionNumbers  {
    public int compareVersion(String version1, String version2) {
        if(version1==null||version1.length()==0||version2==null||version2.length()==0) return 0;
        
        int v1=0, v2=0;
        int i1=0, i2=0;
        while(v1==v2){
            v1=0; v2=0;
            while(i1<version1.length() && version1.charAt(i1)!='.'){
                v1 = v1*10 + version1.charAt(i1++)-'0';
            }
            while(i2<version2.length() && version2.charAt(i2)!='.'){
                v2 = v2*10 + version2.charAt(i2++)-'0';
            }
            
            if(v1!=v2) {
                return v1>v2?1:-1;
            } else {
                if(i1>=version1.length() && i2>=version2.length()) return 0;
                i1++;
                i2++;
            }
        }
        return v1>v2?1:-1;
        
    }
}
