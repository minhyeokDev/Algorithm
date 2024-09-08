import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        LinkedHashSet<String> set = new LinkedHashSet<>();

        for (int i = 0; i < L; i++) {
            String number = br.readLine();
            if (set.contains(number)) {
                set.remove(number);
            }
            set.add(number);

        }
        int count = 0;
        for (String x : set) {
            count++;
            System.out.println(x);
            if (count == K) {
                break;
            }
        }

        br.close();
    }
}
