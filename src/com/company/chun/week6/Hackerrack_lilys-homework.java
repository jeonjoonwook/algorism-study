static int lilysHomework(int[] arr) {
        //treemap은 key를 정렬한 상태로 가지고 있다.
        Map<Integer, Integer> map = new TreeMap<>();
        int[] copyArr = arr.clone();
        for(int i = 0 ; i < copyArr.length ; i++){
            map.put(copyArr[i], i);
        }
        int idx = 0, cnt = 0;
        for (int next : map.keySet()) {
            if (next == copyArr[idx]) {
                idx++;
                continue;
            }
            swap(copyArr, idx, map.get(next));
            map.put(copyArr[map.get(next)], map.get(next));
            cnt++; idx++;
        }

        map = new TreeMap<>(Comparator.reverseOrder());
        for(int i = 0 ; i < arr.length ; i++){
            map.put(arr[i], i);
        }
        idx = 0;
        int tmpCnt = 0;
        for (int next : map.keySet()) {
            if (next == arr[idx]) {
                idx++;
                continue;
            }
            swap(arr, idx, map.get(next));
            map.put(arr[map.get(next)], map.get(next));
            tmpCnt++; idx++;
        }

        return Math.min(cnt, tmpCnt);
    }

    private static void swap(int[] arr, int src, int dest) {
        int tmp = arr[src];
        arr[src] = arr[dest];
        arr[dest] = tmp;
    }