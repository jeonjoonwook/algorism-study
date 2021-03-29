package arrayString;

import java.util.*;

public class StringDistance {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String str1 = scan.nextLine();
		String str2 = scan.nextLine();
		
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray(); 
				
		int idx1=0;
		int idx2=0;
		
		int result=0;
		boolean sameChar = false;
		if(arr1[0]==arr2[0])
		{
			sameChar = true;
			idx1++;
			idx2++;
		}else {
			idx2++;
			result++;
		}
		
		
		while(idx1<arr1.length && idx2 <arr2.length) {
		
			if(arr1[idx1]==arr2[idx2])
			{
				sameChar = true;
				idx1++;
				idx2++;
				continue;
				
			}else if(arr1[idx1]!=arr2[idx2] && sameChar==false)
			{
				idx2++;
				sameChar=false;
				continue;
				
			}else if(arr1[idx1]!=arr2[idx2] && sameChar==true)
			{
				idx2++;
				result++;
				sameChar = false;
				
			}
		}
		
		if(idx1<arr1.length)
		{
			result = -1;
		}
		System.out.println("idx1 : "+idx1);
		System.out.println("result: "+result);
		
	}

}
