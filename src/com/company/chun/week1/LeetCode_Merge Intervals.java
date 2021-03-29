class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));

        // Merge Array
        int idx = 0;
        List<Pair> answerList = new ArrayList<>();
        while(idx < intervals.length){
            if(idx == intervals.length-1) {
                answerList.add(new Pair(intervals[idx][0], intervals[idx][1]));
                break;
            }

            int start = intervals[idx][0];
            int end = intervals[idx][1];
            for (int i = idx + 1; i < intervals.length; i++) {
                if (intervals[i][0] > end) {
                    idx = i;
                    break;
                }
                end = Math.max(end, intervals[i][1]);
                if (i == intervals.length - 1)
                    idx = i + 1;
            }
            answerList.add(new Pair(start, end));
        }

        // ToArray
        int[][] answer = new int[answerList.size()][2];
        for(int i = 0 ; i < answerList.size() ; i++){
            answer[i][0] = answerList.get(i).start;
            answer[i][1] = answerList.get(i).end;
        }
        return answer;
    }



    class Pair{
        int start, end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }
    }
}