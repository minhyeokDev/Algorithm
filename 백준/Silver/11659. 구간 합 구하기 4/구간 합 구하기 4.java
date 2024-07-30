import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] a = new int[100004];
    static int[] d = new int[100004];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        // D[i] = A[1] + A[2] + ... + A[i]
        // D[i] = D[i-1] + A[i]

        d[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            d[i] = d[i - 1] + a[i];
        }
        
        while (m-- > 0) {
            int i, j;
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            int sum = d[j] - d[i - 1];
            System.out.println(sum);
        }

        br.close();

    }
}
