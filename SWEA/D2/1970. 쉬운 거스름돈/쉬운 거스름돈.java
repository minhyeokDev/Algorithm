import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int num = Integer.parseInt(br.readLine());
            int[] moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
            int[] result = new int[8];

            for (int i = 0; i < 8; i++) {
                result[i] = num / moneys[i];
                num = num % moneys[i];
            }
            System.out.println("#" + t);
            for (int i = 0; i < 8; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
        br.close();
    }

}
