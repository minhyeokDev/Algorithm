import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left = 0;
        int right = n - 1;
        int sum = 0;
        int x = Integer.parseInt(br.readLine());
        int count = 0;
        while (left < right) {
            sum = arr[left] + arr[right];
            if (sum == x) {
                count++;
            }
            if (sum <= x) {
                left++;
            } else{
                right--;
            }
        }
        bw.write(Integer.toString(count));
        bw.flush();

    }
}
