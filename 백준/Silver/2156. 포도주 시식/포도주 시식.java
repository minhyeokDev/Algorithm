import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] drinks = new int[n + 2];
        int[] dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            drinks[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = drinks[1];
        dp[2] = drinks[1] + drinks[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + drinks[i], dp[i - 3] + drinks[i - 1] + drinks[i]));
        }

        System.out.println(dp[n]);

        br.close();
    }

}
