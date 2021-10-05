class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int start = 0;
        int end = Integer.MAX_VALUE;
        int k = nums.size();
        int max = 0;
        PriorityQueue<Pair> p = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(int i = 0; i < k; i++) {
            Pair pair = new Pair(nums.get(i).get(0), i, 0);
            p.add(pair);
            max = Math.max(max, nums.get(i).get(0));
            
        }
        
        while(true) {
            Pair poll = p.poll();
            if(max - poll.val < end - start) {
                start = poll.val;
                end = max;
            }
            
            if(nums.get(poll.list).size() == poll.index + 1) {
                break;    
            }
            p.add(new Pair(nums.get(poll.list).get(poll.index + 1),poll.list, poll.index + 1));
            max = Math.max(max, nums.get(poll.list).get(poll.index + 1));
            
        }
        return new int[]{start,end};
    }
    
    class Pair {
        int val;
        int list;
        int index;
        Pair(int val,int list, int index) {
            this.val = val;
            this.list = list;
            this.index = index;
        }
    }
}
