import java.io.*;
import java.util.*;

public class Main {

    static int[][] paper;
    static int N;
    static int[] cnt = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 0, N);
        for (int i = 0; i < 3; i++) {
            System.out.println(cnt[i]);
        }

        br.close();

    }

    public static void solve(int x, int y, int z) {
        if (check(x, y, z)) {
            cnt[paper[x][y] + 1] += 1;
            return;
        }
        int n = z / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solve(x + i * n, y + j * n, n);
            }
        }
    }

    //해당 종이 내부에 같은 숫자로만 채워졌는지 확인하는 함수
    public static boolean check(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (paper[i][j] != paper[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }


}
