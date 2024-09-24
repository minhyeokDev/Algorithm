import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] board;
    static int m, n, h;
    static Queue<Pair> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        board = new int[m][n][h];

        for (int k = 0; k < h; k++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < m; i++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if (board[i][j][k] == 1) {
                        q.offer(new Pair(i, j, k));
                    }
                }
            }
        }

        System.out.println(bfs());

        br.close();
    }

    public static int bfs() {

        while (!q.isEmpty()) {

            Pair p = q.poll();

            for (int k = 0; k < 6; k++) {
                int nX = p.x + dx[k];
                int nY = p.y + dy[k];
                int nZ = p.z + dz[k];

                if (nX < 0 || nY < 0 || nZ < 0 || nX >= m || nY >= n || nZ >= h) {
                    continue;
                }
                if (board[nX][nY][nZ] == 0) {
                    board[nX][nY][nZ] = board[p.x][p.y][p.z] + 1;
                    q.offer(new Pair(nX, nY, nZ));
                }

            }
        }

        int answer = 0;
        if (checkZero()) {
            return -1;
        } else {
            for (int k = 0; k < h; k++) {
                for (int j = 0; j < n; j++) {
                    for (int i = 0; i < m; i++) {
                        answer = Math.max(answer, board[i][j][k]);
                    }
                }
            }
            return answer - 1;
        }

    }

    public static boolean checkZero() {
        for (int k = 0; k < h; k++) {
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    if (board[i][j][k] == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static class Pair {

        int x, y, z;

        public Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

}
