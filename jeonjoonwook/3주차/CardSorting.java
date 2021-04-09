package queueStack;

import java.util.*;
//���� 1715 ī�� �����ϱ�
//ProirityQueue �ƹ��͵� ���� ���س����� ������ ���� ����

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
