package service;

import java.util.List;

import bean.Img;

public interface IImgService {

	void addImg(Img img);

	List<Img> getImgList(Integer sightId);	

}
