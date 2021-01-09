package arrayString;

import java.util.Comparator;

import java.util.*;

//백준 1713 후보 추천하기
class Candidate {
	int time;
	int recommend;
	int num;
	
	Candidate(){
		this.time=0;
		this.recommend=0;
		this.num=0;
	}
	
	Candidate(int time, int recommend, int num)
	{
		this.time=time;
		this.recommend=recommend;
		this.num=num;
	}
	
}

public class CandidateRecommend {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arraySize = scan.nextInt();
		int peopleNum = scan.nextInt();
		boolean flag = true;
		
		ArrayList<Candidate> candidateList = new ArrayList<>();
		int time=0; 
		
		for(int i=0; i<peopleNum; i++)
		{
			int num = scan.nextInt();
			
			for(int j=0; j<candidateList.size(); j++)
			{
				if(candidateList.get(j).num==num)
				{
					candidateList.get(j).recommend++;
					flag = false;
					break;
				}
			}
			
			if(flag)
			{
				if(candidateList.size()==arraySize)
				{
					Collections.sort(candidateList, Comp);
					candidateList.remove(0);
					candidateList.add(new Candidate(time,1,num));
					time++;
				}else {
					candidateList.add(new Candidate(time,1,num));
					time++;
				}
			}
			flag=true;
		}
		
		Collections.sort(candidateList, Comp2);
		for(int i=0; i<candidateList.size(); i++)
		{
			System.out.println(candidateList.get(i).num);
		}
		
	
		
	}
	
	
	
	
	static Comparator <Candidate> Comp = new Comparator <Candidate>() {
		@Override
		public int compare(Candidate a, Candidate b) {
			if(a.recommend==b.recommend)
			{
				return a.time-b.time;
			}else
				return a.recommend-b.recommend;
		}
	};
	
	static Comparator <Candidate> Comp2 = new Comparator <Candidate>() {
		@Override
		public int compare(Candidate a, Candidate b) {
			return a.num-b.num;
		}
	};

}
