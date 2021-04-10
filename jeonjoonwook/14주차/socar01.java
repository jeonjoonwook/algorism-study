package algorithm_java_string_array_10;

import java.util.*;
import java.text.*;


public class socar01 {

	public static void main(String[] args){
		String [] schedule = {"09:05 10", "12:20 5","13:25 6","14:24 5"};
		String current_time = "12:05";
		int K = 10;
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			Date d1 = f.parse("2020-01-01 15:08:00");
			Date d2 = f.parse("2020-01-01 15:05:00");
			if(d1.compareTo(d2)>=0)
			{
				System.out.println("d1이 더 크다");
			}else {
				System.out.println("d1이 더 작다");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		
	}
	
	public static int solve(String[] bakery_schedule, String current_time, int K) 
	{	
		/*
		SimpleDateFormat f =new SimpleDateFormat("HH:mm",Locale.KOREA);
		for(int i=0; i<bakery_schedule.length; i++)
		{
			String[] arr = bakery_schedule[0].split(" ");
			Date d1 = f.parse(current_time);
			Date d2 = f.parse(arr[0]);
			long diff = d1.getTime()-d2.getTime();
			if(diff>=0)
			{
				System.out.println("0보다 큼!");
			}
		}
		*/
		//LocalTime localTime = LocalTime.parse(myDateString, DateTimeFormatter.ofPattern("HH:mm:ss"));
		
		return 0;
	}
}
