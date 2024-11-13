import java.io.*;

public class Solution {

    static int[] board; // 퀸의 위치를 담는다. board[0]=1 -> (0,1)에 하나의 퀸이 있다.
    static int count;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n];
            count = 0;
            solve(0);

            System.out.println("#" + t + " " + count);

        }
        br.close();
    }

    public static void solve(int depth) {
        if (depth == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            board[depth] = i;
            if (isPossible(depth)) {
                solve(depth + 1);
            }
        }
    }

    public static boolean isPossible(int depth) {
        for (int i = 0; i < depth; i++) {
            // 행 차이와 열 차이가 같다면 대각선에 있다는 것
            if (board[i] == board[depth] || Math.abs(depth - i) == Math.abs(board[depth] - board[i])) {
                return false;
            }
        }
        return true;
    }

}
