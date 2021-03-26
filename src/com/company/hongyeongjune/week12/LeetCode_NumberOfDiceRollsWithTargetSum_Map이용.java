package com.company.hongyeongjune.week12;

import java.util.HashMap;
import java.util.Map;

public class Solution_Map이용 {

    public static int MOD = 1000000007;

    public Map<String, Integer> memo = new HashMap<>();

    public int numRollsToTarget(int d, int f, int target) {

        if (d == 0 && target == 0)
            return 1;
        if (d == 0 || target == 0)
            return 0;

        String key = d + "_" + target;

        if (memo.containsKey(key))
            return memo.get(key);

        int answer = 0;
        for (int i = 1; i <= f; i++) {
            answer = (answer + numRollsToTarget(d - 1, f, target - i)) % MOD;
        }

        memo.put(key, answer);

        return answer;
    }
}

