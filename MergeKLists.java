import java.util.ArrayList;


 // Definition for singly-linked list.
   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
      
      public String toString() {
    	  String ret = "{" + val ;
    	  ListNode curr = this;
    	  while(curr.next!=null) {
    		  ret = ret + "," + curr.next.val;
    		  curr = curr.next;
    	  }
    	  ret = ret + "}";
    	  return ret;
    	  
      }
  }

public class MergeKLists {
	public static void main(String[] args) {
//		ListNode l1 = new ListNode(1);
//		l1.next = new ListNode(2);
//		l1.next.next = new ListNode(2);
//		
//		ListNode l2 = new ListNode(1);
//		l2.next = new ListNode(1);
//		l2.next.next = new ListNode(2);
//		
//		System.out.println(l1);
//		System.out.println(l2);
//		MergeKLists testor = new MergeKLists();
//		ListNode trytest = testor.hp(l1,l2);
//		System.out.println(trytest);
		
		String s = "123456";
		System.out.println(s.substring(2,4));
		System.out.println(Integer.MIN_VALUE);
	}
	
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size()==0) return null;
        int len = lists.size();
        int j = 2;
        int k = 1;
        while(k<len) {
            for(int i=0; i<len; i+=j ) {
                ListNode ln1 = lists.get(i);
                if(i+k<len) {
                    ListNode ln2 = lists.get(i+k);
                    ListNode head = hp(ln1, ln2);
                    lists.set(i, head);
                }
               
            }
            j *= 2;
            k *= 2;
        }
        
        return lists.get(0);
    }
    
    private ListNode hp (ListNode l1 , ListNode l2) {
        ListNode head = null;
        ListNode curr = null;
        while(l1!=null && l2!=null) {
            if(l1.val<l2.val) {
            	System.out.println(l1.val);
                if(head == null) {
                    head = new ListNode(l1.val);
                    curr = head;
                } else 
                    curr.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
            	System.out.println(l2.val);
                if(head == null) {
                	
                	head = new ListNode(l2.val);
                    curr = head;
                } else 
                	curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
           	if(curr.next!=null)curr = curr.next;
        }
        
        if(l1!=null) {
            if(head == null) {
                head = l1;
                curr = l1;
            } else 
                curr.next = l1;
        }
            
        if(l2!=null) {
            if(head == null) {
                head = l2;
                curr = l2;
            } else 
                curr.next = l2;
        }
        
        return head;
    }
}