import java.io.*;
import java.util.*;

public class Main {

    static char[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new char[N][2 * N - 1];

        for (int i = 0; i < N; i++) { // 꼭대기 별이 (0,N-1)에 찍힘
            Arrays.fill(board[i], ' '); // 공백으로 채움
        }

        star(0, N - 1, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);

        br.close();
    }

    public static void star(int x, int y, int n) {
        //각 트리가 가장 작은 값으로 됐을때 별찍기
        if (n == 3) {
            board[x][y] = '*'; //트리하나의 맨위의 별
            board[x + 1][y - 1] = board[x + 1][y + 1] = '*'; //가운데 별들
            board[x + 2][y - 2] = board[x + 2][y - 1] = board[x + 2][y] = board[x + 2][y + 1] = board[x + 2][y + 2] = '*'; //마지막 별들
            return;
        } else { // 큰 삼각형 세개로 다시 쪼갬
            //가장 작은값(가장 작은트리가)이 아닐때 3*2의제곱수 이므로 2로 나눠줌.
            int size = n / 2;
            star(x, y, size); // 위 삼각형 탐색
            star(x + size, y - size, size); // 아래왼쪽 삼각형 탐색
            star(x + size, y + size, size); // 아래오른쪽 삼각형 탐색
        }
    }

}
