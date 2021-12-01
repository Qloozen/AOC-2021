package Solutions;

import java.util.ArrayList;

import Utilities.IntegerReader;

public class Day1{
    static IntegerReader reader = new IntegerReader("./Inputs/input1.txt");
    static ArrayList<Integer> input = reader.input;

    public static void puzzleA() {
        int increased = 0;

        for (int i = 1; i < input.size(); i++) {
            int current = input.get(i);
            if(current > input.get(i - 1)) {
                increased ++;
            }
        }

        System.out.println(increased);
    }

    public static void puzzleB() {
        int increased = 0;

        for (int i = 1; i+2 < input.size(); i++) {
            int previous = input.get(i - 1) + input.get(i) + input.get(i + 1);
            int sum = input.get(i) + input.get(i + 1) + input.get(i + 2);
            if(sum > previous) {
                increased ++;
            }
        }

        System.out.println(increased);
    }
}
