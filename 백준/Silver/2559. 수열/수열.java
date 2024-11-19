import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;

        int start = 0;
        int end = k;
        while (end <= n) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            max = Math.max(max, sum);
            start++;
            end++;
        }

        System.out.println(max);
        br.close();
    }

}
