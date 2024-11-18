import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] stickers;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());

            stickers = new int[2][n + 1];
            dp = new int[2][n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                stickers[0][i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                stickers[1][i] = Integer.parseInt(st.nextToken());
            }
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];
            for (int i = 2; i <= n; i++) {
                dp[0][i] = stickers[0][i] + Math.max(dp[1][i - 1], dp[1][i - 2]);
                dp[1][i] = stickers[1][i] + Math.max(dp[0][i - 1], dp[0][i - 2]);
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));

        }


    }

}
