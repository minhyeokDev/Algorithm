import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int k;
    static int r, c;
    static int[][] note = new int[42][42];
    static int[][] paper = new int[12][12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // k개의 스티커 입력
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    paper[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // for문 바깥에 " 루프명 : " 이런식으로 이중for문이든 삼중for문이든 for문에 루프이름을 붙일 수 있고,
            // 그냥 break 하는것보다 break 루프명 이런식으로 적어서 이중for문 전체를 끝낼 수 있음
            check:
            for (int rot = 0; rot < 4; rot++) {
                for (int x = 0; x <= n - r; x++) {
                    for (int y = 0; y <= m - c; y++) {
                        if (postable(x, y)) {
                            break check;
                        }
                    }
                }
                rotate();
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cnt += note[i][j];
            }
        }
        System.out.println(cnt);

        br.close();
    }

    // note의 (x,y)에 모눈종이의 (0,0)이 올라가게 스티커를 붙일 수 있는지 판단하는 함수. 가능할 경우 note를 갱신한 후 true를 반환.
    public static boolean postable(int x, int y) {

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (note[x + i][y + j] == 1 && paper[i][j] == 1) {
                    return false;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (paper[i][j] == 1) {
                    note[x + i][y + j] = 1;
                }
            }
        }

        return true;
    }

    public static void rotate() {
        int[][] tmp = new int[12][12];

        for (int i = 0; i < r; i++) {
            // 내장 함수도 가능
            // System.arraycopy(paper[i], 0, tmp[i], 0, c);
            for (int j = 0; j < c; j++) {
                tmp[i][j] = paper[i][j];
            }
        }

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                paper[i][j] = tmp[r - 1 - j][i];
            }
        }
        int temp = r;
        r = c;
        c = temp;

    }

}
