import java.io.*;
import java.util.*;

public class Main {

    static char[][] board;
    static boolean[][] visited1; // 적록색약 아닌 사람
    static boolean[][] visited2; // 적록색약인 사람

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static Queue<Pair> q1 = new LinkedList<>(); // 적록 색약 아닌 사람
    static Queue<Pair> q2 = new LinkedList<>(); // 적록 색약인 사람

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new char[n][n];
        visited1 = new boolean[n][n];
        visited2 = new boolean[n][n];

        int answer1 = 0;
        int answer2 = 0;
        // 입력
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        // 적록색약이 아닌 사람 bfs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited1[i][j]) {
                    bfs(i, j);
                    answer1++;
                }
            }
        }
        // 적록 색약인 사람 bfs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited2[i][j]) {
                    bfs2(i, j);
                    answer2++;
                }
            }
        }

        System.out.println(answer1 + " " + answer2);

        br.close();

    }

    public static void bfs(int x, int y) {
        visited1[x][y] = true;
        q1.offer(new Pair(x, y, board[x][y]));
        while (!q1.isEmpty()) {
            Pair p = q1.poll();

            for (int k = 0; k < 4; k++) {
                int nX = p.x + dx[k];
                int nY = p.y + dy[k];
                char nowColor = p.color;

                if (nX < 0 || nY < 0 || nX >= n || nY >= n) {
                    continue;
                }
                if (visited1[nX][nY] || board[nX][nY] != nowColor) {
                    continue;
                }
                q1.offer(new Pair(nX, nY, nowColor));
                visited1[nX][nY] = true;
            }
        }

    }

    public static void bfs2(int x, int y) {
        visited2[x][y] = true;
        q2.offer(new Pair(x, y, board[x][y]));
        while (!q2.isEmpty()) {
            Pair p = q2.poll();

            for (int k = 0; k < 4; k++) {
                int nX = p.x + dx[k];
                int nY = p.y + dy[k];
                char nowColor = p.color;

                if (nX < 0 || nY < 0 || nX >= n || nY >= n) {
                    continue;
                }
                if (nowColor == 'R' || nowColor == 'G') {
                    if (visited2[nX][nY] || board[nX][nY] == 'B') {
                        continue;
                    }
                } else {
                    if (visited2[nX][nY] || board[nX][nY] != nowColor) {
                        continue;
                    }
                }
                q2.offer(new Pair(nX, nY, nowColor));
                visited2[nX][nY] = true;
            }
        }
    }

    public static class Pair {

        int x, y;
        char color;

        public Pair(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

}
