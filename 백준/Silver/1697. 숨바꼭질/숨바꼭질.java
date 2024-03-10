import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println(0);
            return;
        }
        boolean visited[] = new boolean[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int size = queue.size();
        int count = 0;
        while (!queue.isEmpty()) {
            count ++;
            size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.remove();
                visited[x] = true;
                if (x - 1 == k || x + 1 == k || x * 2 == k) {
                    System.out.println(count);
                    return;
                }
                if (x-1 >= 0 && !visited[x-1]) {
                    visited[x-1] = true;
                    queue.add(x-1);
                }
                if (x+1 <= 100000 && !visited[x+1]) {
                    visited[x+1] = true;
                    queue.add(x+1);
                }
                if (x*2 <= 100000 && !visited[x*2]) {
                    visited[x*2] = true;
                    queue.add(x*2);
                }
            }
        }
    }

}
