public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tep = 0; 
        ListNode ret = null;
        ListNode temp = null;
        while(l1 != null || l2 != null || tep !=0 ) {
            int sum = 0;
            if(l1!=null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!=null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += tep;
            tep =0;
            if(sum>=10) {
                tep = 1;
                sum -= 10;
            }
            if(temp == null) {
                temp = new ListNode(sum);
                ret = temp;
            }
            
            else {
                temp.next = new ListNode(sum);
                temp = temp.next;
            }
        }
        
        return ret;
    }
}