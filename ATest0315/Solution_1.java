package ATest0315;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] ent = new int[3][2];
	static boolean[] fish;
	static int res, min;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			fish = new boolean[N]; // 낚시터 자리 수
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				ent[i][0] = Integer.parseInt(st.nextToken()) - 1;
				ent[i][1] = Integer.parseInt(st.nextToken());
			} // 출입구별 위치와 사람 수

			// 출입구 순서
			int[] seq = new int[3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i != j) {
						seq[0] = i;
						seq[1] = j;
						seq[2] = 3 - i - j;
						calc(seq);
					}
				}
			}
			sb.append("#" + tc + " " + min + "\n");
			// sb에 저장
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	// 결과값 반환
	public static void calc(int[] seq) {
		for (int flag = 0; flag < 9; flag++) {
			for (int i = 0; i < 3; i++) {
				fill(seq[i], (flag & 1 << i) != 0 ? true : false);
			}
			min = res < min ? res : min;
			Arrays.fill(fish, false);
			res = 0;
		}
	}

	public static void fill(int seqi, boolean left) {
		int idx = ent[seqi][0];
		int num = ent[seqi][1];
		for (; num != 0; num--) {
			if (left) {
				int cur = findNearestL(idx);
				fish[cur] = true;
				res += Math.abs(cur - idx) + 1;
			} else {
				int cur = findNearestR(idx);
				fish[cur] = true;
				res += Math.abs(cur - idx) + 1;
			}
		}
	}

	// 가까운 자리 찾기 left
	public static int findNearestL(int idx) {
		if (!fish[idx])
			return idx;
		for (int len = 1; len < N; len++) {
			if (idx - len > -1 && !fish[idx - len])
				return idx - len;
			if (idx + len < N && !fish[idx + len])
				return idx + len;
		}
		return -1;
	}

	// 가까운 자리 찾기 right
	public static int findNearestR(int idx) {
		if (!fish[idx])
			return idx;
		for (int len = 1; len < N; len++) {
			if (idx + len < N && !fish[idx + len])
				return idx + len;
			if (idx - len > -1 && !fish[idx - len])
				return idx - len;
		}
		return -1;
	}
}