package Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Utilities.AOC;

public class Day6 extends AOC {

    public Day6() {
        super(6);
    }

    @Override
    public void puzzleA(List<String> input) {
        String[] parts = input.get(0).split(",");
        List<Integer> fish = new ArrayList<>();
        for (String s : parts) {
            fish.add(Integer.valueOf(s));
        }

        int days = 1;
        while(days <= 80) {
            int fishToAdd = 0;
            for (int i = 0; i < fish.size(); i++) {
                int interval = fish.get(i);
                if(interval == 0) {
                    fishToAdd ++;
                    fish.set(i, 6);
                } else {
                    fish.set(i, interval -1);
                }
            }

            // add fish
            for (int i = 0; i < fishToAdd ; i++) {
                fish.add(8);
            }
            days ++;
        }

        System.out.println(fish.size());
    }

    @Override
    public void puzzleB(List<String> input) {
        String[] parts = input.get(0).split(",");
        Map<Integer, Long> fish = new HashMap<>();
        for (String s : parts) {
            int key = Integer.valueOf(s);
            fish.put(key, fish.getOrDefault(key, 0L) + 1);
        }

        int days = 1;
        while(days <= 256) {
            Map<Integer, Long> filter = new HashMap<>();

            for (int interval: fish.keySet()) {
                if(interval == 0) {
                    filter.put(6, filter.getOrDefault(6, 0L) + fish.get(interval));
                    filter.put(8, filter.getOrDefault(8, 0L) + fish.get(interval));
                } else {
                    filter.put(interval - 1, filter.getOrDefault(interval -1, 0L) + fish.get(interval));
                }
            }
            days ++;
            fish = filter;
        }

        long sum = 0;
        for(long x: fish.values()) {
            sum += x;
        }

        System.out.println(sum);
    }

    
    
}
