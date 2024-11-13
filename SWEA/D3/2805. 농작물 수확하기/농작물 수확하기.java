import java.io.*;
import java.util.*;

public class Solution {

    static int n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }
            int start = n / 2;
            int end = n / 2;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = start; j <= end; j++) {
                    ans += map[i][j];
                }
                if (i < n / 2) {
                    start--;
                    end++;
                } else {
                    start++;
                    end--;
                }
            }
            System.out.println("#" + t + " " + ans);

        }
        br.close();
    }

}
