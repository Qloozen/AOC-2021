package Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public abstract class AOC {

    public AOC(int day) {
        BufferedReader reader;
        List<String> input = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(String.format("./Inputs/input%d.txt", day)));
            String line;
            while((line = reader.readLine()) != null) {
                input.add(line);
            }
            reader.close();
            puzzleA(new ArrayList<>(input));
            puzzleB(new ArrayList<>(input));
            
        } catch (Exception e) {
            System.out.println(String.format("wrong file path: ./Inputs/input%d.txt", day));
            System.out.println(e);
        }
    }

    public abstract void puzzleA(List<String> input);
    public abstract void puzzleB(List<String> input);

    public List<Integer> inputToInt(List<String> input)
	{
		List<Integer> ints = new ArrayList<>();
		for(String s : input)
			ints.add(Integer.parseInt(s));
		return ints;
	}

}
