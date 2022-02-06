package recursive_function;

import java.util.Scanner;

public class CombinationTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		sc.close();

		System.out.println(comb(n, r));
	}

	public static int comb(int n, int r) {
		// 기본
		if (n == r || r == 0)
			return 1;
		// 유도
		return comb(n - 1, r - 1) + comb(n - 1, r);

	}
}
