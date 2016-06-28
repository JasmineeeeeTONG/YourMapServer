package recommend;

import java.util.LinkedList;
import java.util.List;

import bean.Footprint;
import bean.Sight;
import bean.User;

public class Recommend {
	int uSize;
	int sSize;
	List<User> userList;//包含所有系统中用户的列表
	List<Sight> sightList;//包含所有系统中景点的列表
	List<Footprint> footprintList;//Footprint表中所有的记录
	
	int[][] sightMatrix;
	int[][] visitedMatrix;
	
	public Recommend() {
		//userList = getAllUsers();
		//sightList = getAllSights();
		uSize = userList.size();
		sSize = sightList.size();
		
		//所有景点的特征聚合矩阵，所有入口初始化为0
		sightMatrix = new int[sSize][uSize];
		//所有有user足迹的景点标记矩阵，所有入口初始化为0
		visitedMatrix = new int[sSize][uSize];
		footprintList = new LinkedList<Footprint>();
	}
	
	public void calculateSightMatrix() {
		
		for (int i=0; i<footprintList.size(); i++) {
			Footprint print = footprintList.get(i);
			int type = print.getFootprintType();
			int userId = print.getUserId();
			int sightId = print.getSightId();
			if (type==1) {//收藏
				sightMatrix[sightId][userId] += 2;
			}
			else if (type==2) {//足迹
				sightMatrix[sightId][userId] += 1;
				visitedMatrix[sightId][userId] = 1;
			}
			else if (type==3) {//心愿单
				sightMatrix[sightId][userId] += 2;
			}
			else if (type==4) {//分享
				sightMatrix[sightId][userId] += 2;
			}
		}
	}
	
	public List<Integer> getRecommend(User user) {
		
		List<Integer> visitedSightList = new LinkedList<Integer>();
		List<Integer> nonVisitedSightList = new LinkedList<Integer>();
			
		int userId = user.getUserId();
		for(int i=0; i<sSize; i++) {
			//找到所有该user有足迹的景点 visitedSightList
			if (visitedMatrix[i][userId]==1) {
				visitedSightList.add(i);
			}
			//找到所有该user没有足迹的景点 nonVisitedSightList
			else {
				nonVisitedSightList.add(i);
			}
		}
		
		int visitedSize = visitedSightList.size();
		int nonVisitedSize = nonVisitedSightList.size();
		
		double[][] similarity = new double[visitedSize][nonVisitedSize];
		for (int i=0; i<visitedSize; i++) {
			for (int j=0; j<nonVisitedSize; j++) {
				similarity[i][j] = computeSimilarity(visitedSightList.get(i),nonVisitedSightList.get(j));
			}
		}
		//计算该用户没有足迹的所有景点和他已经有足迹的景点的综合相似度
		double[] recommendRank = new double[nonVisitedSize];
		int[] rankedSightId = new int[nonVisitedSize];
		
		for (int i=0; i<nonVisitedSize; i++) {
			rankedSightId[i] = nonVisitedSightList.get(i); //设置推荐列表的sightId
			
			double score = 0;
			for (int j=0; j<visitedSize; j++) {
				score += similarity[j][i];
			}
			recommendRank[i] = score;
		}
		
		//根据该用户没有足迹的景点与有足迹的景点的相似度，从高到低把没有足迹的景点排序
		boolean needNextPass = true;
		for (int k=1; k<nonVisitedSize && needNextPass; k++) {
			needNextPass = false;
			for (int i=0; i<nonVisitedSize-k; i++) {
				if (recommendRank[i]<recommendRank[i+1]) {
					swap(recommendRank, i, i+1);
					swap(rankedSightId, i, i+1);
					needNextPass = true;
				}
			}
		}
		//返回最多3个推荐景观的Index
		List<Integer> rankedSightIdList = new LinkedList<Integer>();
		int retSize = 3;
		if (nonVisitedSize<=3) retSize = nonVisitedSize;
		for (int i=0; i<retSize; i++) {
			rankedSightIdList.add(rankedSightId[i]);
		}
		return rankedSightIdList;
	}
	
	public double computeSimilarity(int a, int b) {
		double similarity = -1;
		int[] v1 = sightMatrix[a];
		int[] v2 = sightMatrix[b];
		int x = 0;
		int v1LenSqr = 0;
		int v2LenSqr = 0;
		for (int i=0; i<uSize; i++) {
			x += v1[i]*v2[i];
			v1LenSqr += v1[i]*v1[i];
			v2LenSqr += v2[i]*v2[i];
		}
		similarity = x / (Math.sqrt(v1LenSqr) *  Math.sqrt(v2LenSqr));
		return similarity;
	}
	
	public void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public void swap(double[] array, int a, int b) {
		double temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
