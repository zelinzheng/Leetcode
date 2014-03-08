class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<num.length-2; i++) {
            if(i>0 && num[i] == num[i-1] ) continue;
            for(int j=i+1; j<num.length-1; j++) {
                if(num[j] == num[j-1] && j>i+1) continue;
            
                int a = j+1, b = num.length -1;
                
                while(a<=b) {
                    int mid = (a+b)/2;
                    if(num[mid] == -num[i]-num[j]) {
                        ArrayList<Integer> record = new ArrayList<Integer> ();
                        record.add(num[i]);record.add(num[j]); record.add(num[mid]);
                        res.add(record);
                        break;
                    } else if(num[mid]<-num[i]-num[j]) {
                        a = mid + 1;
                    } else {
                        b = mid - 1;
                    }
                }
            
            }
        }
        return res;
    }
}

public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<num.length-2&&num[i]<=0; i++) {
            if(i>0 && num[i] == num[i-1] ) continue;
            int left = i+1, right = num.length-1;
            while(left<right) {
                int sum = num[i]+num[left] + num[right];
                if(sum == 0) {
                    ArrayList<Integer> record = new ArrayList<Integer> ();
                    record.add(num[i]);record.add(num[left]); record.add(num[right]);
                    res.add(record);
                    do {
                    left++;
                    } while (left<num.length && num[left]== num[left-1] );
                    do {
                    right--;
                    } while (right>-1 && num[right] == num[right+1]);
                } else if(sum<0) {
                    left++;
                } else {
                    right--;
                }
                
            }
            
            
        }
        return res;
    }
}
