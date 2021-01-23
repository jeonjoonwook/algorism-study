package queueStack;

import java.util.*;
//백준 1715 카드 정렬하기
//ProirityQueue 아무것도 설정 안해놓으면 작은것 부터 나옴

public class CardSorting {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		long result = 0;
		
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		
		for(int i=0; i<num; i++)
		{
			pq.add(scan.nextLong());
		}
		
		while(pq.size()!=1)
		{
			long sum = pq.poll() + pq.poll();

			result+=sum;
			pq.add(sum);			
		}
		
		System.out.println(result);

	}

}
