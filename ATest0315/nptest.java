package ATest0315;

import java.util.Arrays;
import java.util.Scanner;

public class nptest {

	static int[] arr;
	static int[] brr;

	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		brr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = i + 1;
		do {
			System.out.println(Arrays.toString(arr));
		} while (np());
		sc.close();
	}

	public static boolean np() {
		int i = N - 1;
		while (i != 0 && arr[i - 1] >= arr[i])
			--i;

		if (i == 0)
			return false;

		int j = N - 1;
		while (arr[i - 1] >= arr[j])
			--j;

		swap(i - 1, j);

		int k = N - 1;
		while (i < k)
			swap(i++, k--);
		return true;
	}

	public static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}