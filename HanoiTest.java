package recursive_function;

import java.util.Scanner;

public class HanoiTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		System.out.println(hanoi(n));
	}

	public static int hanoi(int n) {
		// 기본
		if (n == 1)
			return 1;
		// 유도
		return 2 * hanoi(n - 1) + 1;
	}
}
