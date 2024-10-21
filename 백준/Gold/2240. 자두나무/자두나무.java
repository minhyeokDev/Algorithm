import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] a = new int[T + 1];
        int[][][] d = new int[T + 1][W + 1][3]; // 현재시간, 이동 횟수, 나무 번호

        for (int t = 1; t <= T; t++) {
            a[t] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= T; i++) {
            //이동하지 않는 경우 (2번 나무는 이동하지 않으면 못감)
            d[i][0][1] = d[i - 1][0][1] + (a[i] == 1 ? 1 : 0);
            for (int j = 1; j <= W; j++) { // j번 이동
                if (i < j) {
                    break;
                }
                if (a[i] == 1) { // 1번 나무인 경우
                    d[i][j][1] = Math.max(d[i - 1][j - 1][2], d[i - 1][j][1]) + 1;
                    d[i][j][2] = Math.max(d[i - 1][j - 1][1], d[i - 1][j][2]);
                } else { // 2번 나무인 경우
                    d[i][j][1] = Math.max(d[i - 1][j - 1][2], d[i - 1][j][1]);
                    d[i][j][2] = Math.max(d[i - 1][j - 1][1], d[i - 1][j][2]) + 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= W; i++) {
            ans = Math.max(ans, Math.max(d[T][i][1], d[T][i][2]));
        }
        System.out.println(ans);

        br.close();

    }

}
