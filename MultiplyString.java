public class MultiplyString {
    public String multiply(String num1, String num2) {
        if(num1==null || num2 == null) return "0";
        int[] digits = new int[num1.length() + num2.length()];
        
        for(int i=0;i<num1.length(); i++) {
            for(int j=0; j<num2.length(); j++) {
                digits[i+j] += (num1.charAt(num1.length()-1-i)-'0') * (num2.charAt(num2.length()-1-j)-'0');
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<digits.length; i++) {
            if(i<digits.length-1)digits[i+1] += digits[i]/10;
            digits[i] %= 10;
            sb.insert(0, digits[i]);
        }
        
        while(sb.length()>1 && sb.charAt(0) == '0') sb.delete(0,1);
        
        return sb.toString();
    }
}