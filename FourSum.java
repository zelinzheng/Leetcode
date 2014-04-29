public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        //if(num == null || num.length<4) return null;
        
        Arrays.sort(num);
        
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<num.length-3;i++) {
            //if(num[i]>target) break; Wrong code, consider -5 + -4 + -3 + 1 = -11
            if(i>0 && num[i]==num[i-1]) continue;
            
            for(int j=i+1; j<num.length-2;j++) {
                //if(num[j]>target-num[i]) break;
                if(j>i+1 && num[j] == num [j-1]) continue;
                int l=j+1, r=num.length-1;
                while(l<r) {
                    //if(num[l]>target-num[i]-num[j]) break; 
                    int temp = num[i] + num[j] + num[l] + num[r];
                    if(temp == target) {
                        ArrayList<Integer> ai = new ArrayList<Integer>();
                        ai.add(num[i]);
                        ai.add(num[j]);
                        ai.add(num[l]);
                        ai.add(num[r]);
                        ret.add(ai);
                        do{
                            l++;
                        } while(l<r&&num[l]==num[l-1]);
                        do {
                            r--;
                        } while (l<r && num[r] == num[r+1]);
                    } else if(temp<target) l++;
                    else r--;
                }
            }
            
        }
        return ret;
    }
}