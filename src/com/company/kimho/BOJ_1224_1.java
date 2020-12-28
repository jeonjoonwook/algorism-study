package com.company.kimho;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1224_1 
{
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        int[] inputs = Arrays.asList(scanner.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();

        int ascCount = 0;
        int descCount = 0;


        for(int i=0; i<inputs.length-1; i++)
        {
            if(inputs[i+1] - inputs[i] == 1)
            {
                ascCount++;
            }
            if(inputs[i+1] - inputs[i] == -1)
            {
                descCount++;
            }
        }

        if(ascCount == 7 && descCount == 0)
        {
            System.out.println("ascending");
        }
        else if(ascCount == 0 && descCount == 7)
        {
            System.out.println("descending");
        }
        else
        {
            System.out.println("mixed");
        }
    }
}
