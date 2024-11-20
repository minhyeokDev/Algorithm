import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] parent;
    static boolean[] visited;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        list = new ArrayList[n + 1];
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        dfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
        br.close();
    }

    public static void dfs(int node) {
        visited[node] = true;
        for (int next : list[node]) {
            if (!visited[next]) {
                parent[next] = node;
                dfs(next);
            }
        }
    }

}
