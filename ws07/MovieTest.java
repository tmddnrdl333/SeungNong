package com.ssafy.ws07;

import java.util.Scanner;

public class MovieTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		IMovieManager imm = MovieManagerImpl.getInstance();

		w: while (true) {
			System.out.println("--------------------");
			System.out.println("1 - Add\n2 - GetList\n3 - GetMovies\n4 - GetSeriesMovies");
			System.out.println("5 - SearchByTitle\n6 - GetRunningTimeAvg\n0 - Exit");
			System.out.print("Select Menu >> ");
			int n = sc.nextInt();
			switch (n) {
			case 1:
				System.out.println("Series Movie? (y/n)");
				System.out.print(">> ");
				char sel = sc.next().charAt(0);
				if (sel != 'n' && sel != 'y') {
					System.out.println("# 잘못된 입력.");
					break;
				}
				System.out.print("ID >> ");
				int id = sc.nextInt();
				System.out.print("TITLE >> ");
				String title = sc.next();
				System.out.print("DIRECTOR >> ");
				String director = sc.next();
				System.out.print("GENRE >> ");
				String genre = sc.next();
				System.out.print("RUNNING TIME >> ");
				int runningTime = sc.nextInt();
				if (sel == 'n') {
					imm.add(new Movie(id, title, director, genre, runningTime));
				} else if (sel == 'y') {
					System.out.print("SERIES NUMBER >> ");
					int seriesNum = sc.nextInt();
					System.out.print("EPISODE >> ");
					String episode = sc.next();
					imm.add(new SeriesMovie(id, title, director, genre, runningTime, seriesNum, episode));
				}
				break;
			case 2:
				for (Movie tmp : imm.getList()) {
					System.out.println(tmp);
				}
				break;
			case 3:
				for (int i = 0; i < imm.getMovies().length; i++) {
					System.out.println(imm.getMovies()[i]);
				}
				break;
			case 4:
				for (int i = 0; i < imm.getSeriesMovies().length; i++) {
					System.out.println(imm.getSeriesMovies()[i]);
				}
				break;
			case 5:
				System.out.print("Search >> ");
				String str = sc.next();
				System.out.println("Search Result :");
				for (int i = 0; i < imm.searchByTitle(str).length; i++) {
					System.out.println("(" + (i + 1) + ") " + imm.searchByTitle(str)[i]);
				}
				break;
			case 6:
				System.out.println("Average running time is : " + imm.getRunningTimeAvg());
				break;
			default:
				System.out.println("Exit Program.");
				break w;
			}

		}
		sc.close();

	}
}
