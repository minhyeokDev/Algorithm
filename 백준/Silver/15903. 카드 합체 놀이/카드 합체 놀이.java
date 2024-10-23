import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add((long) Integer.parseInt(st.nextToken()));
        }

        while (m-- > 0) {
            long x = pq.poll();
            long y = pq.poll();
            long addNum = x + y;
            pq.add(addNum);
            pq.add(addNum);
        }

        long ans = 0;

        while (!pq.isEmpty()) {
            ans += pq.poll();
        }

        System.out.println(ans);

        br.close();
    }

}
