import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int s;
	static int[] arr = new int[30];
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		func(0, 0);

		if (s == 0) {
			cnt--;
		}
		System.out.println(cnt);

		br.close();
	}

	public static void func(int cur, int total) {
		if (cur == n) {
			if (total == s) {
				cnt++;
			}
			return;
		}
		func(cur + 1, total);
		func(cur + 1, total + arr[cur]);

	}
}
