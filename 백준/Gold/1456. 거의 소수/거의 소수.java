import java.io.*;
import java.util.*;

public class Main {

    static long a;
    static long b;
    static boolean[] isPrime;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        int max = (int) Math.sqrt(b) + 1; // 소수를 찾을 최대 범위
        isPrime = new boolean[max + 1];
        sieve(max);

        // 거의 소수 찾기
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                long power = (long) i * i;
                while (power <= b) {
                    if (power >= a) {
                        count++;
                    }
                    if (b / i < power) {
                        break; // overflow 방지
                    }
                    power *= i;
                }
            }
        }
        System.out.println(count);
        br.close();
    }

    public static void sieve(int n) {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}