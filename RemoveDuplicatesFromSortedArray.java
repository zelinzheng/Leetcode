public class RemoveDuplicatesFromSortedArray

 {
    public int removeDuplicates(int[] A) {
        if(A==null || A.length==0) return 0;
        
        int index=1;
        for(int i=1; i<A.length; i++) {
            if(A[i] == A[i-1]) continue;
            else 
                A[index++] = A[i];
        }
        
        return index;
        
    }
}