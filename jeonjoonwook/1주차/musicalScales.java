package arrayString;

import java.util.*;

//백준 2920 음계
public class musicalScales {

	public static void main(String[] args) {
		String result ="";
		
		Scanner scan = new Scanner(System.in);
		int[] music = new int[8];
		
		for(int i=0; i<music.length; i++)
		{
			music[i] = scan.nextInt();
		}
		
		for(int i=0; i<music.length-1; i++)
		{
			if(music[i]==music[i+1] -1)
			{
				result = "ascending";
			}else if(music[i] == music[i+1]+1)
			{
				result = "descending";
			}else {
				result = "mixed";
				break;
			}
		}
		
		System.out.println(result);
		

	}

}
