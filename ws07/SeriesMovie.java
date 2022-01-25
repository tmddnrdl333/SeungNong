package com.ssafy.ws07;

public class SeriesMovie extends Movie {
	int seriesNum;
	String episode;

	public SeriesMovie() {

	}

	public SeriesMovie(int id, String title, String director, String genre, int runningTime, int seriesNum,
			String episode) {
		super(id, title, director, genre, runningTime);
		setSeriesNum(seriesNum);
		setEpisode(episode);
	}

	public int getSeriesNum() {
		return seriesNum;
	}

	public void setSeriesNum(int seriesNum) {
		this.seriesNum = seriesNum;
	}

	public String getEpisode() {
		return episode;
	}

	public void setEpisode(String episode) {
		this.episode = episode;
	}

	public String toString() {
		return "SeriesMovie [id=" + getId() + ", title=" + getTitle() + ", director=" + getDirector() + ", genre="
				+ getGenre() + ", runningTime=" + getRunningTime() + ", seriesNum=" + seriesNum + ", episode=" + episode
				+ "]";

	}
}
