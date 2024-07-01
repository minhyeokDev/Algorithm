import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		long answer = recur(A, B, C);
		System.out.println(answer);

		br.close();
	}

	public static long recur(int A, int B, int m) {
		if (B == 1) {
			return A % m;
		}
		long val = recur(A, B / 2, m);
		val = val * val % m;
		if (B % 2 == 0) {
			return val;
		}
		return val * A % m;
	}

}
