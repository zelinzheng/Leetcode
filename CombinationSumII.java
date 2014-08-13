public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        helper(num, ret, temp, target, 0);
        return ret;
    }
    
    public void helper(int[] num, List<List<Integer>> ret, ArrayList<Integer> temp, int target, int start) {
        if(target == 0) {
            ret.add((List<Integer>)temp.clone());
            return;
        }
        
        if(target<0 || start == num.length || target<num[start])
            return;
            
        
        
        for(int i=start; i<num.length; i++) {
            if(i!=start && num[i] == num[i-1]) continue;
            temp.add(num[i]);
            helper(num, ret, temp, target-num[i], i+1);
            temp.remove(temp.size()-1);
        }
    }
}