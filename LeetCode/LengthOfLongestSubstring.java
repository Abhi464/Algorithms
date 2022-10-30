class Solution {
//     Find length of a longest substring
    public int lengthOfLongestSubstring(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;
        for(int i = 0 ; i < s.length(); i++) {
            String str = s.charAt(i)+ "";
            if(map.containsKey(str) && map.get(str) >= left) {
                left = Math.max(map.get(str),left) + 1;
            } 
            right = i;
            map.put(str,right);
            result = Math.max(right - left + 1, result);
        }
        return result;
    }
    
}
