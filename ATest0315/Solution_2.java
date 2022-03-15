package ATest0315;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[][] map;
	static int max = 1;
	static int[] totSeq;
	static int N, mn;
	static int[] mobSeq, cusSeq;
	static int res;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			max = 1; // 현재 tc 몹 수 측정할 변수
			res = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int cur = Integer.parseInt(st.nextToken());
					map[i][j] = cur;
					max = cur > max ? cur : max;
				}
			}
			// max만큼의 몹이 존재. 순서 결정
			mn = max * 2;
			totSeq = new int[mn]; // 000111 : 몹3 후 고객3
			Arrays.fill(totSeq, -5);
			totSeq[0] = 5;
			if (max != 1)
				for (int i = max + 1; i < mn; i++)
					totSeq[i] = 5;
			mobSeq = new int[max];
			cusSeq = new int[max];

			do { // total
				for (int i = 0; i < max; i++)
					mobSeq[i] = i + 1;
				do { // mob sequence
					for (int i = 0; i < max; i++)
						cusSeq[i] = -(i + 1);
					do { // customer sequence

						int mCnt = 0, cCnt = 0;
						for (int i = 0; i < mn; i++) {
							if (totSeq[i] == 5) {
								totSeq[i] = mobSeq[mCnt++];
							} else if (totSeq[i] == -5) {
								totSeq[i] = cusSeq[cCnt++];
							}
						}

						// 안되는거 continue
						boolean con = false;
						for (int i = 1; i < mn; i++) {
							if (totSeq[i] < 0) {
								boolean flag = false;
								for (int j = 0; j < i; j++) {
									if (totSeq[j] == -totSeq[i])
										flag = true;
								}
								if (!flag)
									con = true;
							}
						}
						if (!con) {
							// 행동
							int sum = calc();
							res = sum < res ? sum : res;
							// 행동

						}

						for (int i = 0; i < mn; i++)
							totSeq[i] = totSeq[i] > 0 ? 5 : -5;
					} while (npC());

				} while (npM());

			} while (npT());
			sb.append("#" + tc + " " + res + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static boolean npT() {
		int i = mn - 1;
		while (i != 0 && totSeq[i - 1] >= totSeq[i])
			--i;

		if (i == 0)
			return false;

		int j = mn - 1;
		while (totSeq[i - 1] >= totSeq[j])
			--j;

		int temp = totSeq[i - 1];
		totSeq[i - 1] = totSeq[j];
		totSeq[j] = temp;

		int k = mn - 1;
		while (i < k) {
			temp = totSeq[i];
			totSeq[i] = totSeq[k];
			totSeq[k] = temp;
			i++;
			k--;
		}
		return true;
	}

	public static boolean npM() {
		int i = max - 1;
		while (i != 0 && mobSeq[i - 1] >= mobSeq[i])
			--i;

		if (i == 0)
			return false;

		int j = max - 1;
		while (mobSeq[i - 1] >= mobSeq[j])
			--j;

		int temp = mobSeq[i - 1];
		mobSeq[i - 1] = mobSeq[j];
		mobSeq[j] = temp;

		int k = max - 1;
		while (i < k) {
			temp = mobSeq[i];
			mobSeq[i] = mobSeq[k];
			mobSeq[k] = temp;
			i++;
			k--;
		}
		return true;

	}

	public static boolean npC() {
		int i = max - 1;
		while (i != 0 && cusSeq[i - 1] <= cusSeq[i])
			--i;

		if (i == 0)
			return false;

		int j = max - 1;
		while (cusSeq[i - 1] <= cusSeq[j])
			--j;

		int temp = cusSeq[i - 1];
		cusSeq[i - 1] = cusSeq[j];
		cusSeq[j] = temp;

		int k = max - 1;
		while (i < k) {
			temp = cusSeq[i];
			cusSeq[i] = cusSeq[k];
			cusSeq[k] = temp;
			i++;
			k--;
		}
		return true;

	}

	public static int calc() {
		int r = 0, c = 0;
		int sum = 0;
		for (int i = 0; i < mn; i++) {
			int target = totSeq[i];
			int[] tar = find(target);
			sum += Math.abs(tar[0] - r) + Math.abs(tar[1] - c);
			r = tar[0];
			c = tar[1];
		}
		return sum;
	}

	public static int[] find(int num) {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (map[i][j] == num)
					return new int[] { i, j };
		return null;
	}

}