public int[][] merge(int[][] intervals) {
        List<Pair> list = new LinkedList<>();
        for(int[] arr : intervals){
            list.add(new Pair(arr[0], arr[1]));
        }
        list.sort(Comparator.comparing(pair -> pair.start));
        int idx = 0;
        while(idx <list.size()){
            int i = idx+1;
            while(i < list.size() && list.get(idx).end >= list.get(i).start){
                list.get(idx).end = Math.max(list.get(idx).end, list.get(i).end);
                list.remove(i);
            }
            idx++;
        }

        int[][] answer = new int[list.size()][2];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i][0] = list.get(i).start;
            answer[i][1] = list.get(i).end;;
        }

        return answer;
    }

    class Pair{
        int start, end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }