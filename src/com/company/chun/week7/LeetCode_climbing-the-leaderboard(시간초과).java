public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> answer = new LinkedList<>();
        for (Integer integer : player) {
            int rank = 1;
            for (int j = 0; j < ranked.size(); j++) {
                if (ranked.get(j) > integer) {
                    if (j > 0 && ranked.get(j).equals(ranked.get(j - 1)))
                        continue;
                    rank++;
                    if (j == ranked.size() - 1)
                        answer.add(rank);
                } else {
                    answer.add(rank);
                    break;
                }
            }
        }
        return answer;
    }