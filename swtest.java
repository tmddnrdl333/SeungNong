package practice.p0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swtest {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		double[] sb = new double[T];
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			double X = Double.parseDouble(st.nextToken());
			double Y = Double.parseDouble(st.nextToken());
			double h = ((X + Y) - Math.sqrt(X * X + Y * Y - X * Y)) / 6;
			double res = (X - 2 * h) * (Y - 2 * h) * h;
			sb[tc] = res;
		}
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %.6f\n", tc, sb[tc - 1]);
		}
	}
}
