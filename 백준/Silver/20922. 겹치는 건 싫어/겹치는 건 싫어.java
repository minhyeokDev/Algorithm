import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static int[] arr;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        int maxNumber = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxNumber = Math.max(arr[i], maxNumber);
        }

        int end = 0;
        int[] numbers = new int[maxNumber + 1];
        numbers[arr[end]]++;
        for (int start = 0; start < n; start++) {
            while (end + 1 != n && numbers[arr[end + 1]] < k) {
                end++;
                numbers[arr[end]]++;
            }
            max = Math.max(max, (end - start) + 1);
            numbers[arr[start]]--;

        }

        System.out.println(max);

        br.close();

    }

}
