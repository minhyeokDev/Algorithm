import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        int[] aCount = new int[26];
        int[] bCount = new int[26];
        for (int i = 0; i < a.length; i++) {
            aCount[a[i] - 'a']++;
        }
        for (int i = 0; i < b.length; i++) {
            bCount[b[i] - 'a']++;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            int compare = aCount[i] - bCount[i];
            if (compare != 0) {
                ans += Math.abs(compare);
            }
        }
        System.out.println(ans);
        br.close();
    }

}
