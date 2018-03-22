"""
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
"""
class Solution:
    def canCompleteCircuit(self, gas, cost):
        start, end = 0, len(gas) - 1
        fueltank = gas[end] - cost[end]
        while (start < end):
            if fueltank >= 0:
                fueltank += gas[start] - cost[start]
                start += 1
            else:
                end -= 1
                fueltank += gas[end] - cost[end]
        
        if fueltank >= 0:
            return start
        else:
            return -1
