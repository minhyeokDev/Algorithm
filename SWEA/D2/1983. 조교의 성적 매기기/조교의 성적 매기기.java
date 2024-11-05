import java.io.*;
import java.util.*;

public class Solution {

    static String[] arr = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D+"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            Double[] scores = new Double[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                scores[i] = a * 0.35 + b * 0.45 + c * 0.20;
            }

            double goal = scores[k - 1];
            Arrays.sort(scores, Collections.reverseOrder());

            int index = 0;
            for (int i = 0; i < n; i++) {
                if (goal == scores[i]) {
                    index = i;
                }
            }
            index = index / (n / 10);

            System.out.println("#" + t + " " + arr[index]);

        }
        br.close();
    }

}
