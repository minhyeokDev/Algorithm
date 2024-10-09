import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int n;
    static int[] dx = {0, 1, 0, -1}; // 좌 하 우 상
    static int[] dy = {-1, 0, 1, -0};
    static int[] dc = {1, 1, 2, 2};   // 토네이도의 각 방향으로 이동하는 횟수

    //모래가 퍼지는 x방향
    static int[][] dsx = {
        {-1, 1, -2, -1, 1, 2, -1, 1, 0},
        {-1, -1, 0, 0, 0, 0, 1, 1, 2},
        {1, -1, 2, 1, -1, -2, 1, -1, 0},
        {1, 1, 0, 0, 0, 0, -1, -1, -2}
    };
    //모래가 퍼지는 y방향
    static int[][] dsy = {
        {1, 1, 0, 0, 0, 0, -1, -1, -2},
        {-1, 1, -2, -1, 1, 2, -1, 1, 0},
        {-1, -1, 0, 0, 0, 0, 1, 1, 2},
        {1, -1, 2, 1, -1, -2, 1, -1, 0}
    };
    static int[] sandRatio = {1, 1, 2, 7, 7, 2, 10, 10, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = calculateOutSand(n / 2, n / 2);
        System.out.println(answer);

        br.close();
    }

    public static int calculateOutSand(int x, int y) {
        int totalOutSand = 0;
        int curX = x;
        int curY = y;
        while (true) {
            for (int dir = 0; dir < 4; dir++) {
                for (int moveCount = 0; moveCount < dc[dir]; moveCount++) {
                    // 현재 위차애서 이동
                    int nX = curX + dx[dir];
                    int nY = curY + dy[dir];

                    if (nX < 0 || nY < 0 || nX >= n || nY >= n) {
                        return totalOutSand;
                    }

                    // 이동한 위치의 모래 뿌리기
                    int sand = map[nX][nY];
                    map[nX][nY] = 0;
                    int spreadTotal = 0;

                    for (int spread = 0; spread < 9; spread++) {
                        int sandX = nX + dsx[dir][spread];
                        int sandY = nY + dsy[dir][spread];
                        int spreadAmount = (sand * sandRatio[spread]) / 100;
                        if (sandX < 0 || sandX >= n || sandY < 0 || sandY >= n) {
                            totalOutSand += spreadAmount;
                        } else {
                            map[sandX][sandY] += spreadAmount;
                        }
                        // 나누고 남은 것
                        spreadTotal += spreadAmount;
                    }

                    int alphaX = nX + dx[dir];
                    int alphaY = nY + dy[dir];
                    int alphaAmount = sand - spreadTotal;
                    if (alphaX < 0 || alphaX >= n || alphaY < 0 || alphaY >= n) {
                        totalOutSand += alphaAmount;
                    } else {
                        map[alphaX][alphaY] += alphaAmount;
                    }
                    // 이동한 위치 업데이트
                    curX = nX;
                    curY = nY;
                }
            }

            for (int i = 0; i < 4; i++) {
                dc[i] += 2;
            }

        }
    }

}
