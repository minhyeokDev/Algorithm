import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (isPrime(now)) {
                count++;
            }
        }

        System.out.println(count);
        br.close();

    }

    static Boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
