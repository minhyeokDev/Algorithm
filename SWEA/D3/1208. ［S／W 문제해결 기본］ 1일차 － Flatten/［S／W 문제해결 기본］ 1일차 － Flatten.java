import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = 10;
        for (int t = 1; t <= T; t++) {
            int dump = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[100];
            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < dump; i++) {
                Arrays.sort(arr);
                arr[0]++;
                arr[99]--;
            }
            Arrays.sort(arr);
            int result = arr[99] - arr[0];
            System.out.println("#" + t + " " + result);
            
        }
        br.close();
    }

}
