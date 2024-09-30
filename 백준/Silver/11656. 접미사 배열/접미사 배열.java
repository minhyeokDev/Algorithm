import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        String[] arr = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            //arr[i] = "";
//            for (int j = i; j < s.length(); j++) {
//                arr[i] += s.charAt(j);
//            }
            arr[i] = s.substring(i, s.length());
        }

        Arrays.sort(arr);
        for (int i = 0; i < s.length(); i++) {
            sb.append(arr[i]).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
