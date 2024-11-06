import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            map[0][0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0) {
                        map[i][j] = 1;
                    } else if (i == j) {
                        map[i][j] = 1;
                    } else {
                        map[i][j] = map[i - 1][j - 1] + map[i - 1][j];
                    }
                }
            }
            System.out.println("#" + t);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();

            }
        }
        br.close();
    }


}
