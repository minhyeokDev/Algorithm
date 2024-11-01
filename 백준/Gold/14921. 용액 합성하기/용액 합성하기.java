import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = n - 1;
        long min = Integer.MAX_VALUE;
        while (start < end) {
            long sum = a[start] + a[end];
            if (Math.abs(sum) < Math.abs(min)) {
                min = sum;
            }
            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(min);
        br.close();
    }
}
