import java.io.*;
import java.util.*;

public class Main {

    static char[][] board;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        solve(0, 0, N, false);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);

        br.close();
    }

    public static void solve(int x, int y, int size, boolean blank) {

        // 공백 칸일 경우
        if (blank) {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    board[i][j] = ' ';
                }
            }
            return;
        }
        // 더 이상 쪼갤 수 없는 블록일 때
        if (size == 1) {
            board[x][y] = '*';
            return;
        }

        int newSize = size / 3;
        int count = 0;
        for (int i = x; i < x + size; i += newSize) {
            for (int j = y; j < y + size; j += newSize) {
                count++;
                if (count == 5) { // 공백 칸일 경우
                    solve(i, j, newSize, true);
                } else {
                    solve(i, j, newSize, false);
                }
            }
        }

    }

}
