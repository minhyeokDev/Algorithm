import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int m, n, k;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pair> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int count = 0;
            int x, y;
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[m][n];
            visited = new boolean[m][n];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

        br.close();

    }

    public static class Pair {

        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int x, int y) {
        q = new LinkedList<>();
        visited[x][y] = true;

        q.offer(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int k = 0; k < 4; k++) {
                int nX = p.x + dx[k];
                int nY = p.y + dy[k];

                if (nX < 0 || nX >= m || nY < 0 || nY >= n) {
                    continue;
                }
                if (map[nX][nY] != 1 || visited[nX][nY]) {
                    continue;
                }
                q.offer(new Pair(nX, nY));
                visited[nX][nY] = true;
            }
        }

    }

}
