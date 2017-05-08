import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Christina on 2/19/16.
 */
public class MergeInterval {

    //O(nLog(n)), O(1)
    //sorted, unsorted, 一个, 两个不干涉, 两个干涉, 多个干涉
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for (int i = 0; i < intervals.size() - 1; ++i) {
            if (intervals.get(i).end < intervals.get(i + 1).start) {continue;}
            intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i + 1).end);
            intervals.remove(i + 1);
            i--;
        }
        return intervals;
    }
}
