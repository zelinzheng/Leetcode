public class AddBinary {
    public String addBinary(String a, String b) {
        if(a == null) return b;
        if(b == null) return a;
        
        String ret = "";
        int carry = 0;
        while(a.length()>0 || b.length()>0 || carry>0) {
            int A=0, B=0;
            if(a.length()>0) {
                A = a.charAt(a.length()-1) - '0';
                a = a.substring(0, a.length()-1);
            }
            
            if(b.length()>0) {
                B = b.charAt(b.length()-1) - '0';
                b = b.substring(0, b.length()-1);
            }
            
            
            int curr = A + B + carry;
            carry = 0;
            if(curr <= 1) 
                ret = curr + ret;
            else {
                curr -= 2;
                ret = curr + ret;
                carry = 1;
            }

        }
        return ret;
        
    }
}