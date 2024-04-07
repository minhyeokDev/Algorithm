import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] s;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        s = new int[n][n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    static void dfs(int index, int count) {
        if (count == n / 2) {
            diff();
            return;
        }
        for (int i = index; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i+1,count+1);
                visit[i] = false;
            }
        }
    }

    static void diff() {
        int start=0;
        int link=0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if(visit[i] && visit[j]){
                    start += s[i][j];
                    start += s[j][i];
                } else if (!visit[i] && !visit[j]) {
                    link += s[i][j];
                    link += s[j][i];
                }
            }
        }
        int val = Math.abs(start - link);
        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }
        min = Math.min(min, val);
    }
}