import java.util.*;
import java.io.*;

public class Solution {

    static int N, L;
    static int[] t;
    static int[] k;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            t = new int[N + 1];
            k = new int[N + 1];
            dp = new int[N + 1][L + 1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                t[i] = Integer.parseInt(st.nextToken());
                k[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= L; j++) {
                    // 칼로리가 제한 칼로리 넘어가는 경우
                    if (k[i] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - k[i]] + t[i]);
                    }
                }
            }
            System.out.println("#" + testCase + " " + dp[N][L]);


        }
        br.close();
    }

}
