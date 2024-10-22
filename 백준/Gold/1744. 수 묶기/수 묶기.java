import java.io.*;
import java.util.*;

public class Main {

    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> seqP = new ArrayList<>(); // 양수 리스트
        List<Integer> seqN = new ArrayList<>(); // 음수 리스트

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            if (t == 1) {
                ans++;
            } else if (t <= 0) {
                seqN.add(t);
            } else {
                seqP.add(t);
            }
        }
        Collections.sort(seqP, Collections.reverseOrder()); // 양수는 내림차순
        Collections.sort(seqN); // 음수는 오름차순

        int i = 0;
        // 오름차순 정렬
        while (i < seqP.size()) {
            if (i + 1 < seqP.size()) {
                ans += seqP.get(i++) * seqP.get(i++);
            } else {
                ans += seqP.get(i++);
            }
        }
        i = 0;
        while (i < seqN.size()) {
            if (i + 1 < seqN.size()) {
                ans += seqN.get(i++) * seqN.get(i++);
            } else {
                ans += seqN.get(i++);
            }
        }

        System.out.println(ans);

        br.close();
    }


}
