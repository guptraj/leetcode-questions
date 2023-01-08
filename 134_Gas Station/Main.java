import java.util.*;
class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int var = 0;
        int idx = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank = tank + gas[i] - cost[i];
            var += gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                idx = i + 1;
            }
        }
        if (var < 0 || idx == n)
            return -1;
        return idx;
    }
}