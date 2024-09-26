import java.io.*;
import java.util.*;

public class Main {

    static int n;

    static int[][] board = new int[21][21];
    static int[][] board2 = new int[21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        for (int tmp = 0; tmp < 1024; tmp++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board2[i][j] = board[i][j];
                }
            }
            // 5번의 기울이는 방향 정하기
            int brute = tmp;
            for (int i = 0; i < 5; i++) {
                int dir = brute % 4;
                brute /= 4;
                tilt(dir);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(max, board2[i][j]);
                }
            }
        }

        System.out.println(max);

    }

    // 게임판을 상하좌우로 기울이기
    public static void tilt(int dir) {
        while (dir-- > 0) {
            rotate();
        }
        for (int i = 0; i < n; i++) {
            int[] tilted = new int[21]; // board2[i]를 왼쪽으로 기울인 결과를 저장할 변수
            int idx = 0; // tilted 배열에서 어디에 삽입해야 하는지 가리키는 변수
            for (int j = 0; j < n; j++) {

                if (board2[i][j] == 0) {
                    continue;
                }
                if (tilted[idx] == 0) { // 삽입할 위치가 비어있을 경우
                    tilted[idx] = board2[i][j];
                } else if (tilted[idx] == board2[i][j]) { // 같은 값을 갖는 블록이 충돌할 경우
                    tilted[idx++] *= 2;
                } else { // 다른 값을 갖는 블록이 충돌
                    tilted[++idx] = board2[i][j];
                }
            }
            for (int j = 0; j < n; j++) {
                board2[i][j] = tilted[j]; // board2[i]에 tilted를 덮어씀
            }
        }

    }

    public static void rotate() { // board2를 시계 방향으로 90도 회전하는 함수
        int[][] tmp = new int[21][21];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = board2[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board2[i][j] = tmp[n - 1 - j][i];
            }
        }

    }

}
