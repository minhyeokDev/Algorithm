import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                solve(i, j, map[i][j], 1);
                visited[i][j] = false;

            }
        }

        System.out.println(max);
        br.close();
    }

    public static void solve(int row, int column, int sum, int count) {

        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nX = row + dx[i];
            int nY = column + dy[i];

            if (nX < 0 || nY < 0 || nX >= n || nY >= m) {
                continue;
            }
            if (!visited[nX][nY]) {
                if (count == 2) {
                    visited[nX][nY] = true;
                    solve(row, column, sum + map[nX][nY], count + 1);
                    visited[nX][nY] = false;

                }
                visited[nX][nY] = true;
                solve(nX, nY, sum + map[nX][nY], count + 1);
                visited[nX][nY] = false;
            }
        }
    }

}
