import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }
        solve(0, 0, N);

        System.out.println(sb);
        br.close();
    }

    // 압축이 가능한지 해당 공간을 체크해주는 함수
    public static boolean check(int x, int y, int size) {

        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(board[x][y] != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void solve(int x, int y, int size) {

        // 압축이 가능할 경우 하나의 색상으로 압축해
        if(check(x, y, size)) {
            sb.append(board[x][y]);
            return;
        }

        int newSize = size / 2;

        sb.append('(');	// 각 레벨(depth)에서 여는괄호로 시작해야한다.

        solve(x, y, newSize);						// 왼쪽 위
        solve(x, y + newSize, newSize);				// 오른쪽 위
        solve(x + newSize, y, newSize);				// 왼쪽 아래
        solve(x + newSize, y + newSize, newSize);	// 오른쪽 아래

        sb.append(')');	// 해당 레벨이 끝나면 닫는괄호도 닫아준다.


    }

}