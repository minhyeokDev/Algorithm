import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] s;
    static int[] w;
    static int max;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        s = new int[n];
        w = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }

        solve(0);

        System.out.println(max);

        br.close();
    }

    public static void solve(int a) {// a번째 계란으로 다른걸 깰 차례

        if (a == n) {
            max = Math.max(max, count);
            return;
        }
        if (s[a] <= 0 || count == n - 1) {
            solve(a + 1);
            return;
        }  // a번째 계란이 깨져있거나 다른 모든 계란이 깨져있으면 넘어감
        for (int t = 0; t < n; t++) { // t번째 계란을 내려치고 싶다
            if (t == a || s[t] <= 0) {
                continue;
            }
            s[a] -= w[t];
            s[t] -= w[a];
            if (s[a] <= 0) {
                count++;
            }
            if (s[t] <= 0) {
                count++;
            }
            solve(a + 1);
            if (s[a] <= 0) {
                count--;
            }
            if (s[t] <= 0) {
                count--;
            }
            s[a] += w[t];
            s[t] += w[a];
        }

    }

}
