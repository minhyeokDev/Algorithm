import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int totalCount = 0;

            // 행 검사
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1) {
                        count++;
                    } else if (map[i][j] == 0) {
                        if (count == k) {
                            totalCount++;
                        }
                        count = 0;
                    }
                }
                if (count == k) {
                    totalCount++;
                }
            }

            // 열 검사
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int i = 0; i < n; i++) {
                    if (map[i][j] == 1) {
                        count++;
                    } else if (map[i][j] == 0) {
                        if (count == k) {
                            totalCount++;
                        }
                        count = 0;
                    }
                }
                if (count == k) {
                    totalCount++;
                }
            }

            System.out.println("#" + t + " " + totalCount);

        }
        br.close();
    }

}
