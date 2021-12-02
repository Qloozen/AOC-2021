package Solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Day2 {
    public BufferedReader reader;
    public ArrayList<String> input;
    public int horizontal = 0;
    public int depth = 0;
    public int aim = 0;

    public Day2() {
        input = new ArrayList<>();
    }


    public void PuzzleA() {
        try {
            reader = new BufferedReader(new FileReader("./Inputs/input2.txt"));
            String line;
            while((line = reader.readLine()) != null) {
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
                input.add(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println(String.format("Horizontal: %d, Depth: %d. Multiply %d", horizontal, depth, (horizontal * depth)));
    }

    public void PuzzleB() {
        try {
            reader = new BufferedReader(new FileReader("./Inputs/input2.txt"));
            String line;
            while((line = reader.readLine()) != null) {
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
                input.add(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println(String.format("Horizontal: %d, Depth: %d. Multiply %d", horizontal, depth, (horizontal * depth)));
    }
}
