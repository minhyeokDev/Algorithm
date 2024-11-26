import java.io.*;
import java.util.*;

public class Main {

    static int n, x;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        dp = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int count = 0;
        int max = 0;

        for (int i = 1; i <= n; i++) {
            sum += arr[i];

            if (i == x && sum != 0) {
                count = 1;
                max = sum;
            }

            if (i > x) {
                sum -= arr[i - x];
                if (max < sum) {
                    count = 1;
                    max = sum;
                } else if (max == sum) {
                    count++;
                }
            }
        }

        if (max != 0) {
            System.out.println(max);
            System.out.println(count);
        } else {
            System.out.println("SAD");
        }

        br.close();
    }

}
