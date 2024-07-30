import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] d = new int[1000004];
    static int[] pre = new int[1000004];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        d[1] = 0;
        pre[2] = 1;
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            pre[i] = i - 1;

            if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
                d[i] = d[i / 2] + 1;
                pre[i] = i / 2;
            }
            if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
                d[i] = d[i / 3] + 1;
                pre[i] = i / 3;
            }
        }
        System.out.println(d[n]);
        int cur = n;
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(cur + " ");
            if (cur == 1) {
                break;
            }
            cur = pre[cur];
        }
        System.out.println(sb);
        br.close();
    }

}
