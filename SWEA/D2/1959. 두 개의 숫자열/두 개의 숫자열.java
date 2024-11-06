import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            int[] b = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            int ans = 0;

            if (n > m) {
                int index = 0;
                while (index <= n - m) {
                    int temp = 0;
                    for (int i = 0; i < m; i++) {
                        temp += a[i + index] * b[i];
                    }
                    ans = Math.max(ans, temp);

                    index++;
                }
            } else {
                int index = 0;
                while (index <= m - n) {
                    int temp = 0;
                    for (int i = 0; i < n; i++) {
                        temp += a[i] * b[i + index];
                    }
                    ans = Math.max(ans, temp);
                    index++;
                }

            }

            System.out.println("#" + t + " " + ans);

        }
        br.close();
    }

}
