import java.io.*;
import java.util.*;

public class Main {

    static int n, k;

    static int[] W;
    static int[] V;
    static int[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        W = new int[n + 1];

        V = new int[n + 1];

        dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            W[i] = w;
            V[i] = v;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {

                // i번째 무게를 더 담을 수 없는 경우
                if(W[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                // i번째 무게를 더 담을 수 있는 경우
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                }
            }
        }
        System.out.println(dp[n][k]);

        br.close();
    }


}
