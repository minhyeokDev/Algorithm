import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int n;
    static boolean[] isPrime;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        sieve();
        
        int start = 0;
        int end = 0;
        int sum = 0;
        int cnt = 0;
        while (start <= end && end < list.size()) {
            if (sum < n) {
                sum += list.get(end++);
            } else {
                if (sum == n) {
                    cnt++;
                }
                sum -= list.get(start++);
            }
        }

        System.out.println(cnt);

        br.close();

    }

    public static void sieve() {
        isPrime = new boolean[n + 1];

        isPrime[0] = isPrime[1] = false;
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

        for (int i = 1; i <= n; i++) {
            if (isPrime[i]) {
                list.add(i);
            }
        }
        list.add(0);

    }

}
