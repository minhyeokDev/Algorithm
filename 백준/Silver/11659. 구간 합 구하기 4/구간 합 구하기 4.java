import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int n, m;
	static int[] a = new int[100004];
	static int[] d = new int[100004];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d[0] = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			d[i] = d[i - 1] + a[i];
		}
		while (m-- > 0) {
			int i, j;
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			System.out.println(d[j] - d[i - 1]);
		}

	}


}
