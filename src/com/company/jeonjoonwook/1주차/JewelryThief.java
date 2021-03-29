package arrayString;

import java.util.*;

class Jewelry{
	int weight;
	int price;
	Jewelry(){
		this.weight = 0;
		this.price =0;
	}
	Jewelry(int weight, int price){
		this.weight = weight;
		this.price = price;
	}
}


public class JewelryThief {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int k = scan.nextInt();
		int result = 0;		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comp2);
		
		ArrayList<Jewelry> jewelryList = new ArrayList<>();
		ArrayList<Integer> bagList = new ArrayList<>();		
			
		for(int i=0; i<n; i++)
		{
			int weight = scan.nextInt();
			int price = scan.nextInt();			
			jewelryList.add(new Jewelry(weight, price));			
		}
		
		for(int i=0; i<k; i++)
		{
			int weight = scan.nextInt();
			bagList.add(weight);
		}
		
		Collections.sort(jewelryList, Comp);
		Collections.sort(bagList);
		
		int idx = 0;
		for(int i=0; i<bagList.size(); i++)
		{
			while(idx<n)
			{
				if(bagList.get(i)>=jewelryList.get(idx).weight)
				{
					pq.add(jewelryList.get(idx).price);
					idx++;
				}else {
					break;
				}
			}
			
			if(!pq.isEmpty())
			{
				result+=pq.poll();
			}
		}
		System.out.println(result);
	}
	
	static Comparator <Jewelry> Comp = new Comparator <Jewelry>() {
		@Override
		public int compare(Jewelry a, Jewelry b) {
			return a.weight - b.weight;
		}
	};
	static Comparator<Integer> Comp2 = new Comparator<Integer>() {
		
		@Override
		public int compare(Integer a, Integer b) {
			return b-a;
		}
	};

}
