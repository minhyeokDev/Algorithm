import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int[][] board = new int[9][9];
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean answer = true;

            // 가로
            for (int i = 0; i < 9; i++) {
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    set.add(board[i][j]);
                }
                if (set.size() != 9) {
                    answer = false;
                }
            }

            // 세로
            for (int i = 0; i < 9; i++) {
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    set.add(board[j][i]);
                }
                if (set.size() != 9) {
                    answer = false;
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    Set<Integer> set = new HashSet<>();
                    for (int k = i * 3; k < i * 3 + 3; k++) {
                        for (int l = j * 3; l < j * 3 + 3; l++) {
                            set.add(board[k][l]);
                        }
                    }
                    if (set.size() != 9) {
                        answer = false;
                    }
                }
            }

            if (answer) {
                System.out.println("#" + t + " 1");
            } else {
                System.out.println("#" + t + " 0");
            }

        }
        br.close();

    }

}
