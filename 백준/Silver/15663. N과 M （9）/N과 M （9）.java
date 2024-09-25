import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] arr = new int[10];
    static int[] num;
    static boolean[] isUsed = new boolean[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        func(0);

        System.out.println(sb);

        br.close();
    }

    public static void func(int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        int temp = 0;

        for (int i = 0; i < n; i++) {
            if (!isUsed[i] && temp != num[i]) {
                arr[k] = num[i];
                isUsed[i] = true;
                temp = arr[k];
                func(k + 1);
                isUsed[i] = false;

            }
        }

    }


}
