import java.io.*;
import java.util.*;

public class Main {

    static int L;
    static int[][] board;
    static Queue<Pair> q;
    static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            q = new LinkedList<>();
            L = Integer.parseInt(br.readLine());
            board = new int[L][L];
            st = new StringTokenizer(br.readLine());
            int nowX = Integer.parseInt(st.nextToken());
            int nowY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int moveX = Integer.parseInt(st.nextToken());
            int moveY = Integer.parseInt(st.nextToken());
            board[nowX][nowY] = 1;
            q.offer(new Pair(nowX, nowY));
            bfs();

            System.out.println(board[moveX][moveY] - 1);

        }
        br.close();

    }

    public static void bfs() {

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int dir = 0; dir < 8; dir++) {
                int nX = p.x + dx[dir];
                int nY = p.y + dy[dir];

                if (nX < 0 || nY < 0 || nX >= L || nY >= L) {
                    continue;
                }
                if (board[nX][nY] >= 1) {
                    continue;
                }
                board[nX][nY] = board[p.x][p.y] + 1;
                q.offer(new Pair(nX, nY));
            }
        }

    }

}

class Pair {

    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
