/**
 * Created by Christina on 2/19/16.
 */
public class FirstBadVersion {
    /**
     * if is the bad, search the left else search the right
     * */
    //O(logn)
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            boolean isbad = isBadVersion(mid);
            if (mid == 0 && !isbad) {return -1;}
            if (mid == 0 || isbad && !(isBadVersion(mid - 1))) return mid;
            if (isbad) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }

    public boolean isBadVersion(int i) {
        return false;
    }
}
