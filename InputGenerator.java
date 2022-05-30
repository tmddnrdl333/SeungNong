package 계절학기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class InputGenerator {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 1; i < N * N - 1; i++) {
			map[i / N][i % N] = (int) (Math.random() * 4) == 0 ? 1 : 0;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
	}
}
