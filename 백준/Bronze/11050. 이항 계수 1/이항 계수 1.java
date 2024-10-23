import java.util.*;
import java.io.*;

public class Main {

    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int factN = fact(n);

        int factNK = 1;
        if (n - k != 0) {
            factNK = fact(n - k);
        }
        int factK = 1;
        if (k != 0) {
            factK = fact(k);
        }

        int answer = factN / (factNK * factK);
        System.out.println(answer);

        br.close();
    }

    public static int fact(int num) {
        if (num <= 1) {
            return num;
        } else {
            return fact(num - 1) * num;
        }
    }


}
