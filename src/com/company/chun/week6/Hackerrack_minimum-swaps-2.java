static int minimumSwaps(int[] arr) {
        int idx = 0, cnt = 0;
        while (idx < arr.length) {
            if (arr[idx] == idx + 1) {
                idx++;
                continue;
            }
            cnt++;
            swap(arr, idx, arr[idx] - 1);
        }

        return cnt;
    }

    private static int[] swap(int[] arr, int src, int dest) {
        int tmp = arr[src];
        arr[src] = arr[dest];
        arr[dest] = tmp;
        return arr;
    }