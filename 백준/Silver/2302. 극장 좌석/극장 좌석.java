import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] dp = new int[41];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        //dp[n] = dp[n-1] + dp[n-2]
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int ans = 1;

        // vip 좌석을 제외한 나머지 좌석의 경우의 수를 서로 곱함.
        int beforeSeat = 0;
        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(br.readLine());
            ans *= dp[temp - beforeSeat - 1];
            beforeSeat = temp;
        }

        // 마지막 vip 좌석 다음 좌석에서 끝 좌석까지의 경우의 수.
        ans *= dp[n - beforeSeat];

        System.out.println(ans);


        br.close();
    }

}
