import java.io.*;
import java.util.*;

public class Main {

    static int n, s, total;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        total = a[0];
        int end = 0;
        int answer = Integer.MAX_VALUE;
        for (int start = 0; start < n; start++) {
            while (end < n && total < s) {
                end++;
                if (end != n) {
                    total += a[end];
                }
            }
            if (end == n) {
                break;
            }
            answer = Math.min(answer, ((end - start + 1)));
            total -= a[start];

        }
        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }
        System.out.println(answer);

        br.close();
    }

}
