import java.io.*;
import java.util.*;

class Solution {

    static int[] dx = {0, 1, 0, -1}; // 우 하 좌 상
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            int dir = 0;
            int x = 0, y = 0;

            for (int i = 1; i <= n * n; i++) {
                map[x][y] = i;
                int nX = x + dx[dir];
                int nY = y + dy[dir];
                if (nX < 0 || nY < 0 || nX >= n || nY >= n || map[nX][nY] != 0) {
                    dir = (dir + 1) % 4;
                }
                x += dx[dir];
                y += dy[dir];
            }

            sb.append("#").append(t).append("\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            sb.setLength(0);

        }

        br.close();
    }


}
