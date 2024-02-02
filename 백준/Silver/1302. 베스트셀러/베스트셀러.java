import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (map.containsKey(str)) {
                map.replace(str, (map.get(str) + 1));
            } else {
                map.put(str, 1);
            }
        }

        int max = 0;
        for (String s : map.keySet()) {
            max = Math.max(max, map.get(s));
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (String s : list) {
            if (map.get(s) == max) {
                bw.write(s);
                break;
            }
        }
        bw.flush();
        
    }

}
