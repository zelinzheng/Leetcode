public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if(A==null||A.length ==0) return 0;
        
        int len =0;
        int count = 1;
        for(int i=1; i<A.length; i++) {
            if(A[i]!=A[i-1]) {
                A[++len] = A[i];
                count = 1;
            } else {
                count ++;
                if(count <= 2) {
                    A[++len] = A[i];
                }
            }
        }
        
        return len+1;
    }
}