package Solutions;
import java.util.List;

import Utilities.AOC;


public class Day2 extends AOC{

    public Day2() {
        super(2);
    }

    @Override
    public void puzzleA(List<String> input) {
        int horizontal = 0;
        int depth = 0;

        for (String line : input) {
            String[] parts = line.split(" ");
            int amount = Integer.valueOf(parts[1]);
            switch(parts[0]) {
                case "forward":
                    horizontal += amount; 
                    break;
                case "up":
                    depth -= amount; 
                    break;
                case "down":
                    depth += amount; 
                break;
            }
        }
        System.out.println(String.format("Horizontal: %d, Depth: %d. Multiply %d", horizontal, depth, (horizontal * depth)));
    }

    @Override
    public void puzzleB(List<String> input) {
        int horizontal = 0;
        int depth = 0;
        int aim = 0;
       for (String line : input) {
        String[] parts = line.split(" ");
        int amount = Integer.valueOf(parts[1]);
        switch(parts[0]) {
            case "forward":
                horizontal += amount;
                depth += amount * aim;
                break;
            case "up":
                aim -= amount; 
                break;
            case "down":
                aim += amount; 
            break;
            }
       }

       System.out.println(String.format("Horizontal: %d, Depth: %d. Multiply %d", horizontal, depth, (horizontal * depth)));

    }
}
