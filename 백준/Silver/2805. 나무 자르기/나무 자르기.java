import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tree = new int[n];
        st = new StringTokenizer(br.readLine());
        int end = 0;

        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, tree[i]);
        }

        int start = 0;
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

    // x만큼 잘라냈을 때 남는 나무의 길이가 m 이상인가?
    public static boolean solve(int x) {
        long cur = 0;
        for (int i = 0; i < n; i++) {
            if (tree[i] < x) {
                continue;
            }
            cur += tree[i] - x;
        }
        return cur >= m;
    }

}
