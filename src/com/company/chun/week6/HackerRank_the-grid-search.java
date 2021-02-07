class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int gridYSize = Integer.parseInt(st.nextToken());
        int gridXSize = Integer.parseInt(st.nextToken());
        String[] G = new String[gridYSize];
        for(int i = 0  ; i < gridYSize ; i++){
            G[i] = br.readLine();
        }

        st = new StringTokenizer(br.readLine());
        int patternYSize = Integer.parseInt(st.nextToken());
        int patternXSize = Integer.parseInt(st.nextToken());
        String[] P = new String[patternYSize];
        for(int i = 0  ; i < patternYSize ; i++){
            P[i] = br.readLine();
        }
        String s = Solution.gridSearch(G, P);
    }

    static int[][] grid, pattern;
    static String gridSearch(String[] G, String[] P) {
        grid = new int[G.length][G[0].length()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = G[i].charAt(j) - '0';
            }
        }

        pattern = new int[P.length][P[0].length()];
        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[0].length; j++) {
                pattern[i][j] = P[i].charAt(j) - '0';
            }
        }


        for (int r = 0; r <= grid.length - pattern.length; r++) {
            for (int c = 0; c <= grid[0].length - pattern[0].length; c++) {
                if (grid[r][c] != pattern[0][0])
                    continue;
                if (check(r, c)) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    private static boolean check(int r, int c) {
        int gridY = r, gridX = c, patternY = 0, patternX = 0;
        for (; gridY < r + pattern.length; gridY++, patternY++) {
            patternX = 0;
            gridX = c;
            for(; gridX < c + pattern[0].length ; gridX++, patternX++){
                if(grid[gridY][gridX] != pattern[patternY][patternX]){
                    return false;
                }
            }
        }
        return true;
    }
}