import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int k;
    static int[][] map;
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());
            input(com1, com2);
        }
        dfs(1);

        System.out.println(ans);

        br.close();
    }

    public static void input(int x, int y) {
        map[x][y] = 1;
        map[y][x] = 1;
    }

    public static void dfs(int node) {
        visited[node] = true;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && map[node][i] == 1) {
                ans++;
                dfs(i);
            }
        }

    }

}
