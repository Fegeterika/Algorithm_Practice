/*
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        Comparator<Map.Entry<Integer, Integer>> freqComp = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> f1, Map.Entry<Integer, Integer> f2) {
                return f2.getValue() - f1.getValue();
            }
        };
        
        PriorityQueue<Map.Entry<Integer, Integer>> pqueue = new PriorityQueue<>(freqMap.size(), freqComp);
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pqueue.offer(entry);
        }
        
        List<Integer> res = new LinkedList<>();
        while (k > 0) {
            res.add(pqueue.poll().getKey());
            k--;
        }
        return res;
    }
}
