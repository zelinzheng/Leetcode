public class RemoveElement {
    public int removeElement(int[] A, int elem) {
       if(A==null || A.length ==0) return 0;
       
       int begin = 0, end = A.length;
       
       while(begin<end) {
           if(A[begin] == elem) {
               while(end>begin && A[end-1]==elem) {
                   end--;
               }
               if(end == begin) break;
               else A[begin++] = A[--end];
           } else 
                begin++;
       }
       
       return begin;
    }
}