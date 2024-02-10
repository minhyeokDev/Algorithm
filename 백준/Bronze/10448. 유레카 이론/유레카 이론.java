import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] t = new int[45];
        for (int i = 1; i < 45; i++) {
            t[i] = (i * (i + 1)) / 2;
        }

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            System.out.println(solution(t, arr[i]));
        }

    }

    private static int solution(int[] t, int n) {
        for (int i = 1; i < 45; i++) {
            for (int j = i; j < 45; j++) {
                for (int k = j; k < 45; k++) {
                    int sum = t[i] + t[j] + t[k];
                    if (n == sum) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

}
