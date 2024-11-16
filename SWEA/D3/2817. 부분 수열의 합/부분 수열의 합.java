import java.io.*;
import java.util.*;

public class Solution {

    static int n, k;
    static int[] a;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            ans = 0;
            solve(0, 0);

            System.out.println("#" + t + " " + ans);
        }
        br.close();
    }

    public static void solve(int depth, int sum) {
        if (sum == k) {
            ans++;
            return;
        }
        for (int i = depth; i < n; i++) {
            sum += a[i];
            solve(i + 1, sum);
            sum -= a[i];
        }

    }

}
