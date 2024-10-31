import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x, y));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        });

        int min = list.get(0).x;
        int max = list.get(0).y;
        int answer = max - min;

        for (int i = 1; i < list.size(); i++) {
            int curX = list.get(i).x;
            int curY = list.get(i).y;
            if (min <= curX && curY <= max) { //
                continue;
            } else if (curX < max && curY > max) {
                answer += curY - max;
            } else {
                answer += curY - curX;
            }
            min = curX;
            max = curY;
        }

        System.out.println(answer);

        br.close();
    }

    public static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
