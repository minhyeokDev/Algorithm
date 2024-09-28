import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;

    static int n, m;
    static List<Pair> chicken = new ArrayList<>();
    static List<Pair> house = new ArrayList<>();
    static int ans;
    static boolean[] open;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    house.add(new Pair(i, j));
                } else if (board[i][j] == 2) {
                    chicken.add(new Pair(i, j));
                }
            }
        }

        ans = Integer.MAX_VALUE;
        open = new boolean[chicken.size()];

        dfs(0, 0);
        System.out.println(ans);

        br.close();

    }

    public static void dfs(int start, int depth) {
        if (depth == m) { // 치킨 거리의 최솟값 구하기
            int total = 0; // 도시의 치킨 거리

            for (int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE;
                // 어떤 집과 치킨집 중 open한 치킨집의 모든 거리를 비교한다.
                // 그 중, 최소 거리를 구한다.
                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(
                            house.get(i).y - chicken.get(j).y);
                        temp = Math.min(temp, distance);
                    }
                }
                total += temp;
            }
            ans = Math.min(ans, total);
            return;
        }

        // 백트래킹
        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            dfs(i + 1, depth + 1);
            open[i] = false;
        }

    }

    public static class Pair {

        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
