import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] d = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            d[i] = a[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    d[i] = Math.max(d[i], d[j] + a[i]);
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, d[i]);
        }

        System.out.println(answer);
        br.close();
    }

}
