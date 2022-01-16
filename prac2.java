package jan15th;

import java.util.Scanner;

public class prac2 {
	public static void main(String[] args) {
		int y, m;
		int firstDay = 1; // 1년1월1일은월요일

		// 연, 월 입력
		System.out.print("# 연:  ");
		Scanner sc1 = new Scanner(System.in);
		y = sc1.nextInt();
		if (y < 1) {
			System.out.println("# 잘못된  입력입니다.");
			return;
		}
		System.out.print("# 월:  ");
		Scanner sc2 = new Scanner(System.in);
		m = sc2.nextInt();
		if (m < 1 || m > 12) {
			System.out.println("# 잘못된  입력입니다.");
			return;
		}

		// 윤년인지 확인
		int febPlus = 0;
		if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
			febPlus = 1;
		}

		// 윤년 2월 update
		int endDate[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (febPlus == 1) {
			endDate[1]++;
		}

//		// test
//		System.out.println(febPlus + "윤, " + endDate[m - 1] + "일");

		// 출력
		int dayCumul = 0;
		int exactDay;
		for (int i = 1; i < y; i++) {
			dayCumul = dayCumul + 365;
			if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
				dayCumul++;
			}
		}
		for (int j = 1; j < m; j++) {
			dayCumul = dayCumul + endDate[j - 1];
		}
		exactDay = firstDay + dayCumul % 7;

		System.out.printf("=======<%04d-%02d>=======%n", y, m);
		int date = 1;
		loop: for (int k = 0; k < 6; k++) {
			for (int l = 0; l < 7; l++) {
				if (k == 0 && l < exactDay) {
					System.out.printf("   ");
					continue;
				}
				System.out.printf("%3d", date);
				date++;
				if (date == endDate[m - 1]+1) {
					break loop;
				}
			}
			System.out.println();
		}
	}
}
