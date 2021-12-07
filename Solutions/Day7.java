package Solutions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Utilities.AOC;

public class Day7 extends AOC {

    public Day7() {
        super(7);
    }

    @Override
    public void puzzleA(List<String> input) {
        Map<Integer, Integer> positions = new HashMap<>();
        String[] parts = input.get(0).split(",");
        int highestNumber = 0;
        for (String s : parts) {
            int key = Integer.valueOf(s);
            if(key > highestNumber) {
                highestNumber = key;
            }
            positions.put(key, positions.getOrDefault(key, 0) + 1);
        }

        int lowestFuelSpent = 0;
        for (int i = 0; i < highestNumber; i++) {
            int sum = 0;
            for (int key: positions.keySet()) {
                
                sum += Math.abs(key - i) * positions.get(key);
            }

            if(i == 0) {lowestFuelSpent = sum;} else if(sum < lowestFuelSpent){lowestFuelSpent = sum;}
        }

        System.out.println(lowestFuelSpent);

    }

    @Override
    public void puzzleB(List<String> input) {
        Map<Integer, Integer> positions = new HashMap<>();
        String[] parts = input.get(0).split(",");
        int highestNumber = 0;
        for (String s : parts) {
            int key = Integer.valueOf(s);
            if(key > highestNumber) {
                highestNumber = key;
            }
            positions.put(key, positions.getOrDefault(key, 0) + 1);
        }

        int lowestFuelSpent = 0;
        for (int i = 0; i < highestNumber; i++) {
            int sum = 0;
            for (int key: positions.keySet()) {
                int diff = Math.abs(key - i);
                int fuel = 0;
                for (int j = 1; j <= diff; j++) {
                    fuel += j;
                }
                sum += fuel * positions.get(key);
            }

            if(i == 0) {lowestFuelSpent = sum;} else if(sum < lowestFuelSpent){lowestFuelSpent = sum;}
        }

        System.out.println(lowestFuelSpent);
    }
    
}
