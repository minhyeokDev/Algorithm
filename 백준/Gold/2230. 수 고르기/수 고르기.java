import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] a;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(a);

        int end = 0;
        for (int start = 0; start < n; start++) {
            while (end < n && a[end] - a[start] < m) {
                end++;
            }
            if (end == n) {
                break;
            }
            min = Math.min(min, a[end] - a[start]);
        }

        System.out.println(min);

        br.close();
    }

}
