package com.ssafy.ws07;

public class MovieManagerImpl implements IMovieManager {
	private static int MAX_SIZE = 100;
	private Movie[] movieList = new Movie[MAX_SIZE];
	private int size = 0;
	private static IMovieManager instance;

	private MovieManagerImpl() {
	}

	public static IMovieManager getInstance() {
		IMovieManager instance = new MovieManagerImpl();
		return instance;
	}

	public void add(Movie movie) {
		if (size < MAX_SIZE) {
			movieList[size++] = movie;
		}
	}

	public Movie[] getList() {
		Movie[] MovieList = new Movie[size];
		for (int i = 0; i < size; i++) {
			MovieList[i] = movieList[i];
		}
		return MovieList;
	}

	public Movie[] getMovies() {
		boolean[] justBool = new boolean[size];
		int justSize = 0;
		for (int i = 0; i < size; i++) {
			if (!(movieList[i] instanceof SeriesMovie)) {
				justBool[i] = true;
				justSize++;
			}
		}
		Movie[] justMovieList = new Movie[justSize];
		int idx = 0;
		for (int j = 0; j < size; j++) {
			if (justBool[j]) {
				justMovieList[idx] = movieList[j];
				idx++;
			}
		}
		return justMovieList;
	}

	public SeriesMovie[] getSeriesMovies() {
		boolean[] seriesBool = new boolean[size];
		int seriesSize = 0;
		for (int i = 0; i < size; i++) {
			if (movieList[i] instanceof SeriesMovie) {
				seriesBool[i] = true;
				seriesSize++;
			}
		}
		SeriesMovie[] seriesMovieList = new SeriesMovie[seriesSize];
		int idx = 0;
		for (int j = 0; j < size; j++) {
			if (seriesBool[j]) {
				seriesMovieList[idx] = (SeriesMovie) movieList[j];
				idx++;
			}
		}
		return seriesMovieList;
	}

	public Movie[] searchByTitle(String title) {
		int searchSize = 0;
		for (int i = 0; i < size; i++) {
			if (movieList[i].getTitle().contains(title)) {
				searchSize++;
			}
		}
		Movie[] titleMovieList = new Movie[searchSize];
		for (int i = 0; i < searchSize; i++) {
			titleMovieList[i] = movieList[i];
		}
		return titleMovieList;
	}

	public double getRunningTimeAvg() {
		double res = 0.0;
		for (int i = 0; i < size; i++) {
			res += movieList[i].getRunningTime();
		}
		return (double) res / size;
	}
}
