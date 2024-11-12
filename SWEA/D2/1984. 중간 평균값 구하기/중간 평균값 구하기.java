import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[10];
            for (int i = 0; i < 10; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            double sum = 0;
            for (int i = 1; i < 9; i++) {
                sum += arr[i];
            }
            int answer = (int) Math.round(sum / 8);
            System.out.println("#" + t + " " + answer);

        }
        br.close();
    }

}
