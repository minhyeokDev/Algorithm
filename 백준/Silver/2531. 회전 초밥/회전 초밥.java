import java.util.*;
import java.io.*;

public class Main {

    static int n, d, k, c;
    static int[] dishes = new int[30001 * 2];
    static int[] ateCount = new int[3001];
    static int ateKindCount;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        ateCount[c]++;
        ateKindCount = 1;
        answer = 1;

        for (int i = 0; i < n; i++) {
            dishes[i] = Integer.parseInt(br.readLine());
            dishes[i + n] = dishes[i];
        }

        for (int i = 0; i < n * 2; i++) {
            if (i >= k) {
                overEat(dishes[i - k]);
            }
            eat(dishes[i]);
        }

        System.out.println(answer);

        br.close();
    }

    public static void eat(int sushi) {
        if (ateCount[sushi] == 0) {
            ateKindCount++;
            answer = Math.max(answer, ateKindCount);
        }
        ateCount[sushi]++;
    }

    public static void overEat(int sushi) {
        ateCount[sushi]--;
        if (ateCount[sushi] == 0) {
            ateKindCount--;
        }
    }

}
