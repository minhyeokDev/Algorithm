import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            char[] c = new char[n];
            int[] num = new int[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                c[i] = st.nextToken().charAt(0);
                num[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println("#" + t);
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < num[i]; j++) {
                    System.out.print(c[i]);
                    cnt++;
                    if (cnt == 10) {
                        System.out.println();
                        cnt = 0;
                    }
                }
            }
            System.out.println();

        }
        br.close();
    }

}
