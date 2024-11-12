import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = 10;
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            for (int i = 2; i < n - 2; i++) {
                int max = Math.max(arr[i - 2], Math.max(arr[i - 1], Math.max(arr[i + 1], arr[i + 2])));
                if (arr[i] > max) {
                    count += arr[i] - max;
                }
            }
            System.out.println("#" + t + " " + count);

        }
        br.close();

    }

}
