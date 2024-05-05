import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

        Arrays.sort(arr,Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }

		bw.flush();
		br.close();


	}

}
