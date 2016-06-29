package service;

import java.util.List;

import bean.Video;

public interface IVideoService {

	void addVideo(Video video);

	List<Video> getVideoList(Integer sightId);

}
