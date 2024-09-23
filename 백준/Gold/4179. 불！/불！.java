import java.io.*;
import java.util.*;

public class Main {

    static int r, c;
    static char[][] map;
    static int[][] dist1; // 불의 전파 시간
    static int[][] dist2; // 지훈이의 이동 시간
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        dist1 = new int[r][c];
        dist2 = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dist1[i][j] = -1;
                dist2[i][j] = -1;
            }
        }

        map = new char[r][c];

        Queue<Pair> q1 = new LinkedList<>();
        Queue<Pair> q2 = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'F') {
                    q1.add(new Pair(i, j));
                    dist1[i][j] = 0;
                }
                if (map[i][j] == 'J') {
                    q2.add(new Pair(i, j));
                    dist2[i][j] = 0;
                }
            }
        }

        // 불에 대한 BFS
        while (!q1.isEmpty()) {
            Pair p = q1.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = p.x + dx[dir];
                int ny = p.y + dy[dir];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;
                }
                if (dist1[nx][ny] >= 0 || map[nx][ny] == '#') {
                    continue;
                }
                dist1[nx][ny] = dist1[p.x][p.y] + 1;
                q1.add(new Pair(nx, ny));
            }
        }

        // 지훈이에 대한 BFS
        while (!q2.isEmpty()) {
            Pair p = q2.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = p.x + dx[dir];
                int ny = p.y + dy[dir];
                if (nx < 0 || nx >= r || ny < 0
                    || ny >= c) {
                    System.out.print(dist2[p.x][p.y] + 1);
                    return;
                }
                if (dist2[nx][ny] >= 0 || map[nx][ny] == '#') {
                    continue;
                }
                if (dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[p.x][p.y] + 1) {
                    continue;
                }
                dist2[nx][ny] = dist2[p.x][p.y] + 1;
                q2.add(new Pair(nx, ny));
            }
        }

        System.out.println("IMPOSSIBLE");

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
