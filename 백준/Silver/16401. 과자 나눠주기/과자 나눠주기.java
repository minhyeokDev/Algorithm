import java.io.*;
import java.util.*;

public class Main {

    static int m, n;
    static int[] snack;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        snack = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snack);

        int start = 0;
        int end = snack[n - 1];

        while (start < end) {
            int mid = (start + end + 1) / 2;
            if (solve(mid)) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);

        br.close();
    }

    public static boolean solve(int x) {
        if (x == 0) {
            return true;
        }
        long cnt = 0;
        for (int i = 0; i < n; ++i) {
            cnt += snack[i] / x;
        }
        return cnt >= m;
    }

}
