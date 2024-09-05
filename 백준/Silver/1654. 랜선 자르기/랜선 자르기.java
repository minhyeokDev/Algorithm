import java.util.*;
import java.io.*;


public class Main {

    static int k, n;
    static int[] arr = new int[10005];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long start = 1;
        long end = 0x7fffffff;
        while (start < end) {
            long mid = (start + end + 1) / 2;
            if (solve(mid)) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);

    }

    public static boolean solve(long x) {
        long cur = 0;
        for (int i = 0; i < k; i++) {
            cur += arr[i] / x;
        }
        return cur >= n;
    }

}
