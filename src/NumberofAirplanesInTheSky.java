import java.util.Arrays;

/**
 * Created by Christina on 3/3/16.
 */
public class NumberofAirplanesInTheSky {
    public int coundofAirplanes(int[][] airplanes) {
        if (airplanes.length == 0 || airplanes[0].length == 0) { return 0; }
        int len = airplanes.length;
        int[] start = new int[len], end = new int[len];
        for (int i = 0;  i < len; i++) {
            start[i] = airplanes[i][0];
            end[i] = airplanes[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0, j = 0;
        int ret = 0, count = 0;
        while (i < len) {
            if (start[i] >= end[j]) {
                j++;
            } else {
                count++;
                ret = Math.max(count, ret);
            }
            i++;
        }
        return ret;
    }

    public static void main(String[] arg) {
        NumberofAirplanesInTheSky a = new NumberofAirplanesInTheSky();
        System.out.println(a.coundofAirplanes(new int[][] {
                {1, 10}, {2, 3}, {5, 8}, {4, 7}
        }));
        System.out.println(a.coundofAirplanes(new int[][] {
                {1, 10}, {2, 3}, {4, 7}
        }));
        System.out.println(a.coundofAirplanes(new int[][] {
                {1, 10}, {5, 8}, {4, 7}
        }));
    }
}
