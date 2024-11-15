import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = 10;
        int[][] map;
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            map = new int[100][100];

            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = 0;
            for (int i = 0; i < 100; i++) {
                int rowSum = 0;
                int colSum = 0;
                for (int j = 0; j < 100; j++) {
                    rowSum += map[i][j];
                    colSum += map[j][i];
                }

                max = Math.max(max, Math.max(rowSum, colSum));
            }
            int firstSum = 0;
            int secondSum = 0;
            for (int i = 0; i < 100; i++) {
                firstSum += map[i][i];
                secondSum += map[99 - i][99 - i];
            }

            max = Math.max(max, Math.max(firstSum, secondSum));

            System.out.println("#" + n + " " + max);
        }

    }

}
