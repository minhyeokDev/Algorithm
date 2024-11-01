import java.io.*;
import java.util.*;

public class Main {

    static int m, n, k;
    static int[][] board;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pair> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[m][n];
        visited = new int[m][n];

        for (int t = 0; t < k; t++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    board[i][j] = 1;
                }
            }
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 || visited[i][j] == 1) {
                    continue;
                }
                q = new LinkedList<>();
                visited[i][j] = 1;
                q.offer(new Pair(i, j));
                int width = 1;
                count++;
                while (!q.isEmpty()) {
                    Pair p = q.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nX = p.x + dx[dir];
                        int nY = p.y + dy[dir];
                        if (nX < 0 || nY < 0 || nX >= m || nY >= n) {
                            continue;
                        }
                        if (board[nX][nY] == 1 || visited[nX][nY] == 1) {
                            continue;
                        }
                        q.offer(new Pair(nX, nY));
                        visited[nX][nY] = 1;
                        width++;
                    }
                }
                list.add(width);
            }
        }
        Collections.sort(list);

        System.out.println(count);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        br.close();
    }

    static class Pair {

        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
