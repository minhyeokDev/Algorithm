import java.io.*;
import java.util.*;

public class Main {

	static int[][] d = new int[1005][3];
	static int[] r = new int[1005];
	static int[] g = new int[1005];
	static int[] b = new int[1005];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		for(int i = 1; i <= n; i++){
			st = new StringTokenizer(br.readLine());
			r[i] = Integer.parseInt(st.nextToken());
			g[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		d[1][0] = r[1];
		d[1][1] = g[1];
		d[1][2] = b[1];
		for(int i = 2; i <= n; i++){
			d[i][0] = Math.min(d[i-1][1],d[i-1][2])+r[i];
			d[i][1] = Math.min(d[i-1][0],d[i-1][2])+g[i];
			d[i][2] = Math.min(d[i-1][0],d[i-1][1])+b[i];
		}
		System.out.println(Math.min(Math.min(d[n][0], d[n][1]), d[n][2]));

		br.close();
	}

}
