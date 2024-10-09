import java.io.*;
import java.util.*;

public class Main {

    static int n, m, k;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; // 상, 우상, 우, 우하, 하, 좌하, 좌, 좌상
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static ArrayList<FireBall>[][] map; // 파이어볼 이동했을때 정보
    static ArrayList<FireBall> balls; // 모든 파이어볼 정보


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new ArrayList[n][n];
        balls = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            // 초기 파이어볼 입력
            balls.add(new FireBall(r, c, m, s, d));
        }

        while (k-- > 0) {
            moveFire();
            afterMove();
        }

        int sum = 0;

        // 남아있는 파이어볼의 질량
        for (int i = 0; i < balls.size(); i++) {
            FireBall f = balls.get(i);
            sum += f.m;
        }

        System.out.println(sum);

        br.close();
    }

    public static void moveFire() {
        for (int i = 0; i < balls.size(); i++) {
            FireBall f = balls.get(i);
            // (현재위치 + (이동방향 값 + 배열 크기) * 이동 수) % 배열크기
            int nX = (f.x + (dx[f.d] + n) * f.s) % n;
            int nY = (f.y + (dy[f.d] + n) * f.s) % n;
//            int nX = (n + f.x + dx[f.d] * (f.s % n)) % n;
//            int nY = (n + f.y + dy[f.d] * (f.s % n)) % n;
            f.x = nX;
            f.y = nY;
            // 이동한 파이어볼 저장
            map[nX][nY].add(f);
        }

    }


    public static void afterMove() {
        // 이동 후
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].size() < 2) {
                    map[i][j].clear();
                    continue;
                }
                // 두개 이상의 파이어볼이 있다면
                int nM = 0;
                int oddCount = 0;
                int evenCount = 0;
                int nS = 0;
                for (int k = 0; k < map[i][j].size(); k++) {
                    nM += map[i][j].get(k).m;
                    nS += map[i][j].get(k).s;
                    if ((map[i][j].get(k).d % 2) == 1) {
                        //만약 홀수라면
                        oddCount++;
                    } else {
                        // 짝수라면
                        evenCount++;
                    }
                    /**
                     * 여기 제거를 안해줘서 틀렸다!!!!!!!!!!!!
                     */
                    balls.remove(map[i][j].get(k));
                }

                divideFire(i, j, nM, nS, oddCount, evenCount, map[i][j].size());

            }
        }
    }

    public static void divideFire(int r, int c, int nM, int nS, int oddCount, int evenCount,
        int size) {

        // 같은 칸에 있는 파이어볼 없앤다.
        map[r][c].clear();
        // 그다음 새로운 4개를 만들어준다.
        int newM = nM / 5;
        int newS = nS / size;
        // 질량이 0 초과할 경우만 생성
        if (newM > 0) {
            for (int i = 0; i < 4; i++) {
                // 모두 같은 홀수 or 짝수라면
                if (oddCount == size || evenCount == size) {
                    balls.add(new FireBall(r, c, newM, newS, 2 * i));
                } else {
                    balls.add(new FireBall(r, c, newM, newS, (2 * i) + 1));

                }
            }
        }

    }

    public static class FireBall {

        int x, y;
        int m, d, s;

        public FireBall(int x, int y, int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}