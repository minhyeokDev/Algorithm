import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int cnt;
	static boolean[] isUsed1 = new boolean[40];
	static boolean[] isUsed2 = new boolean[40];
	static boolean[] isUsed3 = new boolean[40];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		func(0);
		System.out.print(cnt);
		br.close();
	}

	public static void func(int cur) {
		if (cur == n) {
			cnt++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (isUsed1[i] || isUsed2[i + cur] || isUsed3[cur - i + n - 1]) {
				continue;
			}
			isUsed1[i] = true;
			isUsed2[i+cur] = true;
			isUsed3[cur-i+n-1] = true;
			func(cur+1);
			isUsed1[i] = false;
			isUsed2[i+cur] = false;
			isUsed3[cur-i+n-1] = false;
		}
	}
}
