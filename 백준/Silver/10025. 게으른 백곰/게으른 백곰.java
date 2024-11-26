import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[1000001];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x] = g;
        }
        int max = 0;
        int sum = 0;
        int window = 2 * k + 1;
        for (int i = 0; i <= 1000000; i++) {
            sum += arr[i];
            if (i == window - 1) {
                max = sum;
            }
            if (i >= window) {
                sum -= arr[i - window];
            }

            if (sum > max) {
                max = sum;
            }
        }

        System.out.println(max);
        br.close();

    }

}
