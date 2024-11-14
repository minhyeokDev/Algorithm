import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            char[][] arr = new char[8][8];

            for (int i = 0; i < 8; i++) {
                arr[i] = br.readLine().toCharArray();
            }
            int result = 0, r = 0, c = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    r = 0;
                    c = 0;
                    for (int k = 0; k < n / 2; k++) {
                        if (j <= 8 - n && arr[i][j + k] == arr[i][j + n - k - 1]) {
                            r++;
                        }
                        if (i <= 8 - n && arr[i + k][j] == arr[i + n - k - 1][j]) {
                            c++;
                        }
                    }
                    if (r == n / 2) {
                        result++;
                    }
                    if (c == n / 2) {
                        result++;
                    }
                }
            }
            System.out.println("#" + tc + " " + result);
        }
        br.close();

    }

}
