import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int num = Integer.parseInt(br.readLine());
            int[] arr = {2, 3, 5, 7, 11};
            int[] result = new int[5];
            for (int i = 0; i < 5; i++) {
                while (true) {
                    if (num % arr[i] != 0) {
                        break;
                    }
                    num = num / arr[i];
                    result[i]++;
                }
            }
            System.out.print("#" + t + " ");
            for (int i = 0; i < 5; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
        br.close();
    }

}
