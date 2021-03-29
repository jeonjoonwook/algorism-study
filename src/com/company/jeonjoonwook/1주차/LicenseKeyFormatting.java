package arrayString;

public class LicenseKeyFormatting {

	public static void main(String[] args) {

		//String S = "5F3Z-2e-9-w";
		String S = "2-5g-3-J";
		int k = 4;
		System.out.println(licenseKeyFormatting(S, k));
	}

	public static String licenseKeyFormatting(String S, int K) {
		String temp = S.toUpperCase();
		String result = "";
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<temp.length(); i++)
		{
			if(temp.charAt(i)=='-')
			{
				continue;
			}
			sb.append(temp.charAt(i));
		}
		int len = sb.length();
		for(int i=K; i<len; i=i+K)
		{
			sb.insert(len-i, '-');
		}
		
		result =sb.toString();
		return result;
	}
}
