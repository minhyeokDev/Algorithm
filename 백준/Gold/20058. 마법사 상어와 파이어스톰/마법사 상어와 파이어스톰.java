import java.io.*;
import java.util.*;

public class Main {

    static int N, Q;
    static int[][] map;
    static int land, totalIce;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        N = (int) Math.pow(2, N);
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] L = new int[Q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        // Q 만큼 진행.
        for (int i = 0; i < Q; i++) {

            // 먼저 격자를 나누고 회전
            map = divide(L[i]);
            // 얼음 녹이기
            map = melt();

        }
        land = totalIce = 0;

        search();

        System.out.println(totalIce);
        System.out.println(land);
        br.close();
    }

    public static int[][] divide(int L) {
        int[][] temp = new int[N][N];
        L = (int) Math.pow(2, L);
        for (int i = 0; i < N; i += L) {
            for (int j = 0; j < N; j += L) {
                rotate(temp, i, j, L);
            }
        }
        return temp;
    }

    public static void rotate(int[][] temp, int x, int y, int L) {
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                temp[x + i][y + j] = map[x + L - 1 - j][y + i];
            }
        }
    }

    public static int[][] melt() {
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            temp[i] = map[i].clone();
        }
        // 여기서 복제한 뒤, 얼음은 한번에 녹아야하는데 map에 일일이 얼음 녹은걸 반영한다면 결과가 맞지 않기 때문에 temp 사용해야함!
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = 0;
                if (map[i][j] == 0) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int nX = i + dx[k];
                    int nY = j + dy[k];
                    if (nX < 0 || nY < 0 || nX >= N || nY >= N) {
                        continue;
                    }
                    if (map[nX][nY] != 0) {
                        count++;
                    }

                }
                if (count < 3) {
                    temp[i][j]--;
                }
            }
        }
        return temp;
    }

    public static void search() {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 남아있는 얼음의 합
                totalIce += map[i][j];

                if (map[i][j] > 0 && !visited[i][j]) {
                    q.offer(new Pair(i, j));
                    visited[i][j] = true;
                    int count = 1;
                    while (!q.isEmpty()) {
                        Pair p = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = p.x + dx[k];
                            int ny = p.y + dy[k];
                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                                continue;
                            }
                            if (map[nx][ny] > 0 && !visited[nx][ny]) {
                                visited[nx][ny] = true;
                                q.offer(new Pair(nx, ny));
                                count++;
                            }
                        }

                    }
                    land = Math.max(land, count);

                }
            }
        }

    }

    public static class Pair {

        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
