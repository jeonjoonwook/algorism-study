class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length())
            return new ArrayList<>();

        int start = 0, point = 0;
        List<Integer> answer = new ArrayList<>();
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for(int i = 0 ; i < p.length() ; i++){
            pMap.putIfAbsent(p.charAt(i), 0);
            pMap.put(p.charAt(i), pMap.get(p.charAt(i))+1);
        }
        int length = 0;
        while(point < s.length()){
            char c = s.charAt(point);
            if(pMap.containsKey(c)){
                sMap.putIfAbsent(s.charAt(point), 0);
                sMap.put(s.charAt(point), sMap.get(s.charAt(point))+1);
            }else{
                sMap.clear();
                start = ++point;
                length = 0;
                continue;
            }
            point++;

            if(sMap.get(c) <= pMap.get(c)){
                length++;
            }else{
                while(sMap.get(c) > pMap.get(c)){
                    char tmp = s.charAt(start);
                    if(tmp != c && pMap.containsKey(tmp))
                        length--;
                    sMap.put(tmp, sMap.get(tmp)-1);
                    start++;
                }
            }

            if(length == p.length()){
                answer.add(start);
                sMap.put(s.charAt(start), sMap.get(s.charAt(start))-1);
                length--;
                start++;
            }
        }
        return answer;
    }
}