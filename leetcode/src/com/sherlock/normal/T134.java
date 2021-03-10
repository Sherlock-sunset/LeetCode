package c\\om.sherlock.normal;

import java.util.Deque;
import java.util.LinkedList;

public class T134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        Deque<Integer> deque = new LinkedList<>();
        int currentGas = 0, index = -1;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i]) {
                index = i;
                break;
            }
        }
        if (index == -1) return index;
        int endIndex = index - 1 >= 0 ? index - 1 : gas.length - 1;
        while (deque.size() != gas.length) {
            if (index >= gas.length) index = 0;
            //
            currentGas = currentGas + gas[index] - cost[index];
            deque.addFirst(index);
            while (currentGas < 0) {
                int startIndex = deque.removeLast();
                if (endIndex == startIndex) return -1;
                currentGas = currentGas + cost[startIndex] - gas[startIndex];
            }
            index++;
        }
        return deque.getLast();
    }
}
