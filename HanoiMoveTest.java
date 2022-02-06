package recursive_function;

import java.util.Scanner;

public class HanoiMoveTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n >> ");
		int n = sc.nextInt();
		sc.close();

		hanoi(n, 1, 2, 3);
	}

	public static void hanoi(int n, int from, int tmp, int to) {
		if (n == 0)
			return;
		// n-1개 이동
		hanoi(n - 1, from, to, tmp);
		// 마지막 하나 이동
		System.out.println(n + " : " + from + " -> " + to);
		// n-1개 이동
		hanoi(n - 1, tmp, from, to);
	}
}
