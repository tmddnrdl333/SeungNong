package jan15th;

import java.util.Scanner;

public class prac6 {
	public static void main(String[] args) {

		// 맵 형성
		int[][] map = new int[7][7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				map[i][j] = i * 7 + j;
			}
		}

		// 시작 위치
		int ur = 2;
		int uc = 2;

		Scanner sc = new Scanner(System.in);
		while (true) {
			// 맵 출력
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 7; j++) {
					if (i == ur && j == uc) {
						System.out.printf("<%2d>", map[i][j]);
					} else {
						System.out.printf(" %2d ", map[i][j]);
					}
				}
				System.out.println();
			}
			// 이동 정보 입력
			System.out.print("# 이동할 칸을 입력하시오 >> ");
			int n = sc.nextInt();
			System.out.print("# 1:상  2:하  3:좌  4:우 (그 외: 종료)>> ");
			int sel = sc.nextInt();
			// 종료 입력시
			int[][] move = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };
			if (sel < 1 || sel > 4) {
				System.out.println("종료합니다.");
				break;
			}
			// 이동
			for (int i = 1; i <= n; i++) {
				ur += move[0][sel - 1];
				uc += move[1][sel - 1];
				if (ur < 0 || ur > 6 || uc < 0 || uc > 6) {
					System.out.println("# 벽!");
					ur -= move[0][sel - 1];
					uc -= move[1][sel - 1];
					break;
				}
			}
		}
		sc.close();
	}
}
