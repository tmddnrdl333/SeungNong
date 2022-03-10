package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1. 배열을 오름차순으로 정렬한다
// 2. 아래 과정을 반복한다.
// - 1. 뒤부터 탐색하며 교환 위치 찾기 (i꼭대기, i-1교환위치)
// - 2. 뒤부터 탐색하며 교환위치와 교환할 큰 값 위치 찾기 (j)
// - 3. 두 위치 값 교환
// - 4. 꼭대기 위치부터 맨 뒤까지 오름차순 정렬

public class L1_NextPermutation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N;
	static int[] input;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			input[i] = Integer.parseInt(st.nextToken());

		// 1. 오름차순 정렬
		Arrays.sort(input);

		// 2. np
		do {
			// 행동
			System.out.println(Arrays.toString(input));
			// 행동
		} while (np());

	}

	public static boolean np() {
		// 1. 교환위치 찾기
		int i = N - 1;
		while (i > 0 && input[i - 1] >= input[i])
			--i;

		if (i == 0)
			return false;

		// 2. 교환위치와 교환할 큰 값 위치 찾기
		int j = N - 1;
		while (input[i - 1] >= input[j])
			--j;

		// 3. 교환하기
		swap(i - 1, j);

		// 4. 꼭대기 뒤로 오름차순 정렬
		int k = N - 1;
		while (i < k)
			swap(i++, k--);

		return true;
	}

	public static void swap(int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
