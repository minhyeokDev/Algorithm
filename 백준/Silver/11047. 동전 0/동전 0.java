import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int k;

	static int[] a = new int[15];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		int answer = 0;

		for(int i = n-1; i >= 0; i--){
			answer += k / a[i];
			k %= a[i];
		}

		System.out.println(answer);
		br.close();
	}

}
