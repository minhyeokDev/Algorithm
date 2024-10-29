import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int minLeft = 0;
        int minRight = 0;

        int start = 0;
        int end = n - 1;
        long min = Long.MAX_VALUE;
        while (start < end) {
            long sum = arr[start] + arr[end];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                minLeft = start;
                minRight = end;
            }
            if (sum >= 0) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(arr[minLeft] + " " + arr[minRight]);

        br.close();
    }

}
