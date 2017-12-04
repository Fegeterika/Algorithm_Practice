/*
Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

Note:
Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
As long as a house is in the heaters' warm radius range, it can be warmed.
All the heaters follow your radius standard and the warm radius will the same.
*/

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        // This is O(n log n ) solution using array sort
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int heaterIndex = 0;
        int reqDist = 0;
        
        for (int i = 0; i < houses.length; i++) {
            while (heaterIndex != heaters.length - 1 && 
                   Math.abs(houses[i] - heaters[heaterIndex]) >= Math.abs(houses[i] - heaters[heaterIndex + 1])) {
                heaterIndex += 1;                
            }
            
            reqDist = Math.max(Math.abs(houses[i] - heaters[heaterIndex]), reqDist);
        }
        
        return reqDist;
        
        // This is O(n^2) solution
        /* Map<Integer, Integer> minDist = new HashMap<Integer, Integer>();
        int minDistance = 0;
        for (int house : houses) {
            for (int heater : heaters) {
                int dist = Math.abs(house - heater);
                if (minDist.containsKey(house) && dist < minDist.get(house)) {
                    minDist.replace(house, dist);
                } else if (!minDist.containsKey(house)) {
                    minDist.put(house, dist);
                }
            }
        }
        
        for (Map.Entry<Integer, Integer> distance : minDist.entrySet()) {
            System.out.println(distance.getValue());
            if (minDistance < distance.getValue()) {
                minDistance = distance.getValue();
            }
        }
        
        return minDistance; */
    }
}
