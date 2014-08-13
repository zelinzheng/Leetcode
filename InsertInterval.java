/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i=0;
        for(; i<intervals.size(); i++) {
            if(intervals.get(i).start<newInterval.start){
                if(intervals.get(i).end<newInterval.start) {
                    continue;
                }
                else {
                    intervals.get(i).end = Math.max(intervals.get(i).end, newInterval.end);
                    break;
                }
            } else {
                if(intervals.get(i).start>newInterval.end) {
                    intervals.add(i, newInterval);
                    return intervals;
                }
                else {
                    intervals.get(i).start = newInterval.start;
                    intervals.get(i).end = Math.max(intervals.get(i).end, newInterval.end);
                    break;
                }
            }
        }
        if(i==intervals.size()) {
            intervals.add(newInterval);
            return intervals;
        }
        
        Interval prev = intervals.get(i);
        int currentIndex = i++;
        for(;i<intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if(prev.end>= curr.start) {
                prev.end = Math.max(prev.end, curr.end);
            } else {
                intervals.set(++currentIndex, curr);
                prev = curr;
            }
        }
        return intervals.subList(0, currentIndex+1);
        
    }
}