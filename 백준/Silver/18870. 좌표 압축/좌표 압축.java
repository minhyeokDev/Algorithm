import java.io.*;
import java.util.*;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] origin = new int[n];
        int[] sorted = new int[n];
        HashMap<Integer, Integer> rankingMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sorted[i] = origin[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        int rank = 0;

        for (int v : sorted) {
            if (!rankingMap.containsKey(v)) {
                rankingMap.put(v, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int key : origin) {
            int ranking= rankingMap.get(key);
            sb.append(ranking).append(' ');
        }

        System.out.print(sb);

        br.close();

    }
}
