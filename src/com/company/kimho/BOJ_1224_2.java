package com.company.kimho;

import java.util.Arrays;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int[] nums = Arrays.asList(scanner.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();

        int sum = 0;

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N && j != i; j++)
            {
                for(int k=0; k<N && k != j; k++)
                {
                    int tmpSum = nums[i]+nums[j]+nums[k];
                    if(tmpSum > sum && tmpSum <= M)
                    {
                        sum = tmpSum;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
