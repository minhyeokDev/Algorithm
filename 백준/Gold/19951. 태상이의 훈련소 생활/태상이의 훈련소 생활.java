import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            solve(a, b, k);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(h[i] + " ");
        }

        br.close();
    }

    public static void solve(int a, int b, int k) {
        for (int i = a; i <= b; i++) {
            if (k < 0) {
                h[i] += k;
            } else {
                h[i] += k;
            }
        }
    }


}
