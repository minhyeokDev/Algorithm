import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pair> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                q = new LinkedList<>();
                int width = 1;
                visited[i][j] = true;
                q.offer(new Pair(i, j));
                count++;
                while (!q.isEmpty()) {
                    Pair p = q.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nX = p.x + dx[dir];
                        int nY = p.y + dy[dir];
                        if (nX < 0 || nY < 0 || nX >= n || nY >= n) {
                            continue;
                        }
                        if (visited[nX][nY] || board[nX][nY] == 0) {
                            continue;
                        }
                        q.offer(new Pair(nX, nY));
                        width++;
                        visited[nX][nY] = true;
                    }
                }
                list.add(width);

            }
        }

        Collections.sort(list);

        System.out.println(count);
        for (int i : list) {
            System.out.println(i);
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
