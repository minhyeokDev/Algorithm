import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                arr[s.charAt(i) - 97]++;
            } else {
                arr[s.charAt(i) - 65]++;
            }
        }

        int max = -1;
        char ch = '?';

        for (int i = 0; i < 26; i++) {
            if (max < arr[i]) {
                max = arr[i];
                ch = (char) (i + 65);
            } else if (max == arr[i]) {
                ch = '?';
            }
        }
        System.out.println(ch);
    }

}