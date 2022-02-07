package practice;

import java.util.Arrays;
import java.util.Scanner;

public class pcsTest {
	static int totalCnt = 0;
	static int[] arr, nums;
	static int n, r;
	static boolean[] isSel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("1.순열 2.조합 3.중복순열 4.중복조합 : ");
		int menu = sc.nextInt();
		System.out.print("n : ");
		n = sc.nextInt();
		System.out.print(": ");
		arr = new int[n];
		isSel = new boolean[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		System.out.print("r : ");
		r = sc.nextInt();
		nums = new int[r];
		sc.close();
		switch (menu) {
		case 1:
			permu(0);
			break;
		case 2:
			combi(0, 0);
			break;
		case 3:
			permuR(0);
			break;
		case 4:
			combiR(0, 0);
			break;
		default:
			System.out.println("end");
		}
		System.out.println("total : " + totalCnt);
	}

	// 1. 순열
	public static void permu(int cnt) {
		// 기본
		if (cnt == r) {
			System.out.println(Arrays.toString(nums));
			totalCnt++;
			return;
		}
		// 유도
		for (int i = 0; i < n; i++) {
			if (!isSel[i]) {
				nums[cnt] = arr[i];
				isSel[i] = true;
				permu(cnt + 1);
				isSel[i] = false;
			}
		}
	}

	// 2. 조합
	public static void combi(int cnt, int start) {
		// 기본
		if (cnt == r) {
			System.out.println(Arrays.toString(nums));
			totalCnt++;
			return;
		}
		// 유도
		for (int i = start; i < n; i++) {
			nums[cnt] = arr[i];
			combi(cnt + 1, i + 1);
		}
	}

	// 3. 중복순열
	public static void permuR(int cnt) {
		// 기본
		if (cnt == r) {
			System.out.println(Arrays.toString(nums));
			totalCnt++;
			return;
		}
		// 유도
		for (int i = 0; i < n; i++) {
			nums[cnt] = arr[i];
			permuR(cnt + 1);
		}
	}

	// 4. 중복조합
	public static void combiR(int cnt, int start) {
		// 기본
		if (cnt == r) {
			System.out.println(Arrays.toString(nums));
			totalCnt++;
			return;
		}
		// 유도
		for (int i = start; i < n; i++) {
			nums[cnt] = arr[i];
			combiR(cnt + 1, i);
		}
	}
}
