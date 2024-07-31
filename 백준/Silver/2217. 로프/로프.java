import java.util.*;
import java.io.*;

public class Main {

    static int n;

    static Integer[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        a = new Integer[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(a, Collections.reverseOrder());

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, (a[i - 1] * i));
        }

        System.out.println(answer);

        br.close();
    }

}
