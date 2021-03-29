static String isValid(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxCnt = 0;
        char maxChar = '*';
        for(int i = 0 ; i < s.length() ; i++){
            if(map.get(s.charAt(i)) == null)
                map.put(s.charAt(i), 0);
            map.put(s.charAt(i), map.get(s.charAt(i))+1);
            if(map.get(s.charAt(i)) > maxCnt){
                maxCnt = map.get(s.charAt(i));
                maxChar = s.charAt(i);
            }
        }

        boolean isAllSame = true, isOneBigger = true;
        for(char c : map.keySet()){
            if(maxCnt != map.get(c))
                isAllSame = false;
            if(maxCnt-1 != map.get(c) && maxChar != c)
                isOneBigger = false;
        }

        if(isAllSame || isOneBigger)
            return "YES";

        boolean oneOut = true;
        for(char c : map.keySet()){
            if(maxCnt == map.get(c))
                continue;
            if(map.get(c) == 1 && oneOut){
                oneOut = false;
            }else{
                return "NO";
            }
        }

        return "YES";
    }