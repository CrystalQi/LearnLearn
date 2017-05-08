import java.util.*;

public class KClosestPoints {

    //heap better
    //O(N lg K) running time + O(K) memory
    public List<Point> getKClosest(List<Point> points, int k) {
        if(points == null || points.size() == 0) {
            return new ArrayList<>();
        }
        Queue<Point> heap = new PriorityQueue<>(k, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                return distance(a) - distance(b);
            }
        });
        for(Point p : points) {
            heap.add(p);
        }

        return new ArrayList<>(heap);
    }

    public int distance(Point p) {
        return (int) Math.sqrt(p.x * p.x + p.y * p.y);
    }


    private static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }



    public static void main(String[] args) {
        List<Point> points = new ArrayList<Point>();
        KClosestPoints a = new KClosestPoints();
        points.add(new Point(1,1));
        points.add(new Point(1,2));
        points.add(new Point(2,1));
        points.add(new Point(3,1));
        points.add(new Point(1,4));
        points.add(new Point(-4,1));
        points.add(new Point(-5,-5));
        List<Point> result = a.getKClosest(points, 6);
        for(Point p : result) {
            System.out.println(p);
        }
    }

}

