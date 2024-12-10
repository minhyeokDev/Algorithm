import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] num;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        num = new int[n];
        arr = new int[m];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        func(0);

        System.out.println(sb);

        br.close();
    }

    public static void func(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = -1;
        for (int i = 0; i < n; i++) {
            int now = num[i];
            if (before != now) {
                before = now;
                arr[depth] = num[i];
                func(depth + 1);
            }
        }
    }

}
