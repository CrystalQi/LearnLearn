/**
 * Created by Christina on 2/29/16.
 */
public class FindtheCelebrity {

    /**
     * iterate the array
     * to abandon the one
     * */
    //O(n), O(1)
    public int findCelebrity(int n) {
        int left = 0, right = 1;
        while (right < n) {
            if (knows(left, right)) {
                left = right;
            }
            right++;
        }
        for (int i = 0; i < n; i++) {
            if (i == left) {continue;}
            if (knows(left, i) || !knows(i, left)) {return -1;}
        }
        return left;
    }

    private boolean knows(int a, int b) {
        return false;
    }
}
