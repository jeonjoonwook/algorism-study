package com.company.hongyeongjune.week8.ICT.문제3번;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static long maxInversions(List<Integer> arr) {

        long count = 0;

        for (int i = 0; i < arr.size() - 1; i++) {
            long low = 0;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) > arr.get(j)) low++;
            }

            long high = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(i) < arr.get(j)) high++;
            }

            count += (high * low);
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(maxInversions(Arrays.asList(
                50,
                615,
                368,
                260,
                115,
                944,
                873,
                353,
                893,
                961,
                333,
                527,
                803,
                474,
                143,
                469,
                555,
                918,
                378,
                147,
                488,
                349,
                899,
                191,
                566,
                695,
                253,
                741,
                191,
                903,
                105,
                363,
                164,
                749,
                835,
                181,
                334,
                212,
                379,
                859,
                358,
                869,
                714,
                318,
                815,
                730,
                501,
                760,
                856,
                411,
                931
        )));
    }
}
