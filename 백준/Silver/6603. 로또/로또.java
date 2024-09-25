import java.io.*;
import java.util.*;

public class Main {

    static int[] S;
    static int n;
    static StringBuilder sb = new StringBuilder();
    static boolean[] isUsed;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            S = new int[n];
            arr = new int[15];
            isUsed = new boolean[15];

            for (int i = 0; i < n; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(S);
            func(0, 0);
            System.out.println(sb);

        }

        br.close();

    }

    public static void func(int k, int start) {
        if (k == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            if (!isUsed[i]) {
                arr[k] = S[i];
                isUsed[i] = true;
                func(k + 1, i);
                isUsed[i] = false;
            }
        }

    }

}
