import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static int T, w, h;
    static Queue<Pair> q1; // 불
    static Queue<Pair> q2; // 상근
    static int[][] dist1; // 불이 이동하는 시간
    static int[][] dist2; // 상근이가 이동하는 시간

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {

            boolean escape = false;
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            dist1 = new int[h][w];
            dist2 = new int[h][w];
            for (int i = 0; i < h; i++) {
                Arrays.fill(dist1[i], -1);
                Arrays.fill(dist2[i], -1);
            }
            // 초기 입력
            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j);

                    if (str.charAt(j) == '*') { // 불
                        q1.offer(new Pair(i, j));
                        dist1[i][j] = 0;
                    } else if (str.charAt(j) == '@') { // 상근이 위치
                        q2.offer(new Pair(i, j));
                        dist2[i][j] = 0;
                    }
                }
            }

            // 불에 대한 bfs
            while (!q1.isEmpty()) {
                Pair p = q1.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nX = p.x + dx[dir];
                    int nY = p.y + dy[dir];

                    if (nX < 0 || nY < 0 || nX >= h || nY >= w) {
                        continue;
                    }
                    if (map[nX][nY] == '#' || dist1[nX][nY] >= 0) {
                        continue;
                    }
                    dist1[nX][nY] = dist1[p.x][p.y] + 1;
                    q1.offer(new Pair(nX, nY));
                }
            }

            // 상근이 bfs
            while (!q2.isEmpty() && (!escape)) {
                Pair p = q2.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nX = p.x + dx[dir];
                    int nY = p.y + dy[dir];

                    if (nX < 0 || nY < 0 || nX >= h || nY >= w) {
                        System.out.print(dist2[p.x][p.y] + 1 + "\n");
                        escape = true;
                        break;
                    }
                    if (map[nX][nY] == '#' || dist2[nX][nY] >= 0) {
                        continue;
                    }
                    if (dist1[nX][nY] != -1
                        && dist1[nX][nY] <= dist2[p.x][p.y] + 1) { // 불의 전파 시간을 조건에 추가
                        continue;
                    }
                    dist2[nX][nY] = dist2[p.x][p.y] + 1;
                    q2.offer(new Pair(nX, nY));
                }
            }
            if (!escape) {
                System.out.println("IMPOSSIBLE");
            }

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

}
