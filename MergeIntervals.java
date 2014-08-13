/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();
        
        for(Interval interval:intervals) {
            if(tree.containsKey(interval.start)) {
                tree.put(interval.start, Math.max(tree.get(interval.start), interval.end));
            } else {
                tree.put(interval.start, interval.end);
            }
        }
        
        Set<Map.Entry<Integer,Integer>> set = tree.entrySet();
        
        List<Interval> ret = new ArrayList<Interval>();
        for(Map.Entry<Integer, Integer> entry:set) {
            if(ret.size() ==0) 
                ret.add(new Interval(entry.getKey(), entry.getValue()));
            else {
                Interval current = ret.get(ret.size()-1);
                if(entry.getKey()<= current.end) {
                    current.end = Math.max(current.end,entry.getValue());
                } else {
                    ret.add(new Interval(entry.getKey(), entry.getValue()));
                }
            }
        }
        
        return ret;
        
    }
}