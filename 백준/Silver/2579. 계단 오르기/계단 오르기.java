import java.io.*;
import java.util.*;

public class Main {

    static int[] step = new int[305];
    static int[] dp = new int[305];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = step[1];
        if (n > 1) {
            dp[2] = step[2] + step[1];
        }
        if (n > 2) {
            dp[3] = step[3] + Math.max(step[2], step[1]);
        }
        for (int i = 4; i <= n; i++) {
            dp[i] = step[i] + Math.max(step[i - 1] + dp[i - 3], dp[i - 2]);
        }
        System.out.println(dp[n]);

        br.close();
    }

}
