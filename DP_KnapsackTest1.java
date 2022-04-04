package lecture0401;

import java.util.Scanner;

public class DP_KnapsackTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		int[] weights = new int[N + 1];
		int[] profits = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}

		int[] D = new int[W + 1];

		// 물건 0일 때 모든 무게를 만족하는 최적값은 0
		// 무게 0에 대해 모든 물건의 최적값은 0

		// 물건 1부터 가방의 모든 무게에 대해 최적값 저장
		for (int i = 1; i <= N; i++) {
			for (int w = W; w >= weights[i]; w--) {

				// 해당 물건 무게로 w 가방에 담을 수 있다면
				// - 담는 경우 / 담지 않는 경우 둘 중 최적값

				D[w] = Math.max(D[w - weights[i]] + profits[i], D[w]);

			}
		}
		System.out.println(D[W]);
	}
}