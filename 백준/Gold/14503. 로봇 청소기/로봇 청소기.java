import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0}; // 북동남서
    static int[] dy = {0, 1, 0, -1};
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                // 맵 초기 입력
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);

        System.out.println(count);

        br.close();
    }

    public static void dfs(int x, int y, int dir) {
        // 처음 칸은 청소되지 않은 칸
        map[x][y] = -1;

        //현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
        for (int i = 0; i < 4; i++) {
            // 90도 회전
            dir = (dir + 3) % 4; // 왼쪽 방향으로 변환 (북 -> 서 -> 남 -> 동){
            int nX = x + dx[dir];
            int nY = y + dy[dir];

            if (nX >= 0 && nY >= 0 && nX < n && nY < m) {
                if (map[nX][nY] == 0) {
                    count++;
                    dfs(nX, nY, dir);
                    //여기서 return을 안하면 복귀하는 도중 뒤로가서 다른 곳을 청소할수가 있음.
                    return;
                }
            }
        }

        // 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는
        // 뒤쪽 칸이 벽이 아니라는 전제 하에, 바라보는 방향을 유지한 채로 한 칸 후진.
        int d = (dir + 2) % 4; //반대 방향으로 후진
        int bx = x + dx[d];
        int by = y + dy[d];
        if (bx >= 0 && by >= 0 && bx < n && by < m && map[bx][by] != 1) {
            dfs(bx, by, dir); //후진이니까 바라보는 방향은 유지
        }
    }
}
