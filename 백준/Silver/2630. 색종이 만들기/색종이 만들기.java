import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static int[][] paper;

    static int[] cnt = new int[2];

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
        for (int i = 0; i < 2; i++) {
            System.out.println(cnt[i]);
        }

        br.close();
    }

    public static boolean check(int x, int y, int n) {

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (paper[x][y] != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void solve(int x, int y, int z) {
        if (check(x, y, z)) {
            cnt[paper[x][y]] += 1;
            return;
        }
        int n = z / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                solve(x + i * n, y + j * n, n);
            }
        }
    }

}
