import java.io.*;
import java.util.*;

public class Main {

    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        isPrime = new boolean[n + 1];
        sieve(n);
        for (int i = m; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }

        br.close();

    }

    public static void sieve(int n) {
        isPrime[1] = false;
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

    }

}
