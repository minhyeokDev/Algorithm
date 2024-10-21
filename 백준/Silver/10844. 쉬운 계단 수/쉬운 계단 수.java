import java.io.*;
import java.util.*;

public class Main {

    static long[][] d = new long[101][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 9; i++) {
            d[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int k = 0; k <= 9; k++) {
                if (k != 0) {
                    d[i][k] += d[i - 1][k - 1];
                }
                if (k != 9) {
                    d[i][k] += d[i - 1][k + 1];
                }
                d[i][k] %= 1000000000;
            }
        }
        long ans = 0;

        for (int i = 0; i <= 9; i++) {
            ans += d[n][i];
        }
        ans %= 1000000000;

        System.out.println(ans);

        br.close();
    }

}
