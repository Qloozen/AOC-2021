package Solutions;

import java.util.List;

import Utilities.AOC;

public class Day1 extends AOC{
    public Day1() {
        super(1);
    }

    @Override
    public void puzzleA(List<String> input) {
        List<Integer> in = inputToInt(input);
        int increased = 0;

        for (int i = 1; i < in.size(); i++) {
            int current = in.get(i);
            if(current > in.get(i - 1)) {
                increased ++;
            }
        }

        System.out.println(increased);
    }

    @Override
    public void puzzleB(List<String> input) {
        int increased = 0;
        List<Integer> in = inputToInt(input);

        for (int i = 1; i+2 < in.size(); i++) {
            int previous = in.get(i - 1) + in.get(i) + in.get(i + 1);
            int sum = in.get(i) + in.get(i + 1) + in.get(i + 2);
            if(sum > previous) {
                increased ++;
            }
        }

        System.out.println(increased);
    }
}
