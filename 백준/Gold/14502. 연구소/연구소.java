import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max = Integer.MIN_VALUE;
    static Queue<Pair> viruses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0);

        System.out.println(max);

        br.close();
    }

    public static void solve(int count) {

        // 모든 경우의 수에 벽을 3개 넣고,
        // 바이러스가 퍼지고 난 뒤
        // 개수를 비교해서 최대값 비교 ?

        // 벽을 3개 세웠다면 그 때의 안전 영역 크기 구하기
        if (count == 3) {

            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    solve(count + 1);
                    map[i][j] = 0;
                }
            }
        }

    }

    public static void bfs() {
        viruses = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    viruses.offer(new Pair(i, j));
                }
            }
        }

        int[][] copyMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            copyMap[i] = map[i].clone();
        }

        while (!viruses.isEmpty()) {

            Pair p = viruses.poll();

            for (int dir = 0; dir < 4; dir++) {

                int nX = p.x + dx[dir];
                int nY = p.y + dy[dir];

                if (nX < 0 || nY < 0 || nX >= n || nY >= m) {
                    continue;
                }
                if (copyMap[nX][nY] == 0) {
                    copyMap[nX][nY] = 2;
                    viruses.offer(new Pair(nX, nY));
                }
            }
        }

        // 바이러스 다 퍼지고 난 뒤 안전 영역 체크

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    sum++;
                }
            }
        }
        max = Math.max(max, sum);

    }

    public static class Pair {

        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
