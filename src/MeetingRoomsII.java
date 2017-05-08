import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Christina on 2/19/16.
 */
public class MeetingRoomsII {

    /**
     * Definition for an interval.
     * public class Interval {
     * int start;
     * int end;
     * Interval() { start = 0; end = 0; }
     * Interval(int s, int e) { start = s; end = e; }
     * }Maximum Product of Word Lengths
     */

    //O(nlog(n)), O(1)
    public int minMeetingRooms(Interval[] intervals) {
        int n = intervals.length;
        int start[] = new int[n];
        int end[] = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int roomsNum = 0;
        int endP = 0;
        for (int i = 0; i < n; i++) {
            if (start[i] < end[endP]) {
                roomsNum++;
            } else {
                endP++;
            }
        }
        return roomsNum;
    }


    //heap
    //O(nlog(n)), heap.size(max: n)
    public int minMeetingRooms1(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });

        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval interval = heap.poll();
            if (intervals[i].start >= interval.end) {
                interval.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(interval);

        }
        return heap.size();
    }

    public static void main(String[] arg) {
        MeetingRoomsII a = new MeetingRoomsII();
        System.out.println(a.minMeetingRooms1(new Interval[]{new Interval(2, 15), new Interval(36, 45),
                new Interval(9, 29), new Interval(16, 23), new Interval(4, 9)}));
    }
}