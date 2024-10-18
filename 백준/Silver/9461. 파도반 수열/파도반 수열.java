import java.io.*;
import java.util.*;

public class Main {

    static long[] d = new long[105];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        d[1] = 1;
        d[2] = 1;
        d[3] = 1;

        for (int i = 4; i <= 100; i++) {
            d[i] = d[i-2] + d[i-3];
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(d[n]);
        }

        br.close();
    }

}
