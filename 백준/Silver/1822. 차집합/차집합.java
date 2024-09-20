import java.io.*;
import java.util.*;

public class Main {

    static int nA, nB;

    static int[] a;
    static int[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        nA = Integer.parseInt(st.nextToken());
        nB = Integer.parseInt(st.nextToken());

        a = new int[nA];
        b = new int[nB];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nA; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        List<Integer> answer = new ArrayList<>();

        Set<Integer> bSet = new HashSet<>();
        for (int i = 0; i < nB; i++) {
            bSet.add(b[i]);
        }

        for (int i = 0; i < nA; i++) {
            if (!bSet.contains(a[i])) {
                answer.add(a[i]);
            }
        }

        System.out.println(answer.size());
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }

        br.close();
    }


}
