public class NextPermutation {
    public void nextPermutation(int[] num) {
        if(num == null || num.length<2) return;
        // 4 3 2 1 2
        // 2431
        // 3421 3
       int i=num.length-2;
       for(; i>-1; i--) {
           if(num[i]<num[i+1]) {
               int j = i+1;
               while(j<num.length-1 && num[j+1]>num[i]) j++;
               int temp = num[i];
               num[i] = num[j];
               num[j] = temp;
               break;
           }
       }
       i++;
       int len = num.length-i;
       for(int offset=0; offset<len/2 ;offset++) {
           int temp = num[i+offset];
             num[i+offset] = num[num.length-1-offset];
             num[num.length-1-offset] = temp;
       }
    }
}