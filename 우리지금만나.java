package 계절학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 우리지금만나 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	static int[][] map;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int cur = Integer.parseInt(st.nextToken());
				map[i][j] = cur == 0 ? 0 : N * N;
			}
		}

		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		map[0][0] = -1;
		map[N - 1][N - 1] = 1;
		q1.add(0);
		q2.add(N * N - 1);
		int time = 2;
		boolean flag = true;
		int ans = N * N;
		while (flag) {
			int size1 = q1.size(), size2 = q2.size();
			if (size1 == 0 || size2 == 0) {
				ans = -1;
				break;
			}
			for (; size1 != 0; size1--) {
				int p1 = q1.poll();
				int r = p1 / N, c = p1 % N;
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d], nc = c + dc[d];
					if (nr == -1 || nc == -1 || nr == N || nc == N)
						continue;
					else if (map[nr][nc] != 0)
						continue;
					map[nr][nc] = -time;
					q1.add(nr * N + nc);
				}
			}
			for (; size2 != 0; size2--) {
				int p2 = q2.poll();
				int r = p2 / N, c = p2 % N;
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d], nc = c + dc[d];
					if (nr == -1 || nc == -1 || nr == N || nc == N)
						continue;
					else if (map[nr][nc] > 0)
						continue;
					if (map[nr][nc] < 0) {
						flag = false;
						int temp = nr * N + nc;
						ans = temp < ans ? temp : ans;
					}
					map[nr][nc] = time;
					q2.add(nr * N + nc);
				}
			}
			time++;
		}

		if (ans == -1)
			System.out.println(ans);
		else
			System.out.println((ans / N + 1) + " " + (ans % N + 1));

	}
}
