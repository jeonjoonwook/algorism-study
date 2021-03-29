package arrayString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Interval2{
	int start;
	int end;
	
	Interval2(){
		start=0;
		end=0;
	}
	Interval2(int s, int e){
		start=s;
		end=e;
	}
}

public class MergeInterval {

	public static void main(String[] args) {
		Interval2 in1 = new Interval2(1,3);
		Interval2 in4 = new Interval2(2,6);
		Interval2 in2 = new Interval2(8,10);
		Interval2 in3 = new Interval2(15,18);
		
		List<Interval2> Intervals = new ArrayList<>();
		Intervals.add(in1);
		Intervals.add(in2);
		Intervals.add(in3);
		Intervals.add(in4);
		
		MergeInterval a = new MergeInterval();
		List<Interval2> list = a.merge(Intervals);
		
		a.print(list);
	}
	
	public List<Interval2> merge(List<Interval2> Intervals)
	{
		List<Interval2> result = new ArrayList<Interval2>();
		Collections.sort(Intervals, comp2);
		
		Interval2 a = Intervals.get(0);
		
		for(int i=1; i<Intervals.size(); i++)
		{
			if(a.end>=Intervals.get(i).start)
			{
				a.end=Intervals.get(i).end;
			}else {
				result.add(a);
				a=Intervals.get(i);
			}
		}
		result.add(a);
		
		return result;
	}
	
	Comparator comp2 = new Comparator <Interval2>() {		
		@Override
		public int compare(Interval2 a, Interval2 b) {
			return a.start -b.start;
		}
	};
	
	void print(List<Interval2> list)
	{
		for(int i=0; i<list.size(); i++)
		{
			Interval2 in = list.get(i);
			System.out.println(in.start + " " + in.end);
		}
	}
		
}
