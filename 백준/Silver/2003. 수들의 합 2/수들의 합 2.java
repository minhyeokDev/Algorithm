import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        while (true) {
            if (sum >= m) {
                sum -= a[start++];
            } else if (end == n) {
                break;
            } else {
                sum += a[end++];
            }
            if (sum == m) {
                count++;
            }
        }

        System.out.println(count);

        br.close();
    }

}
