package Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class StringReader {
    public BufferedReader reader;
    public ArrayList<String> input;

    public StringReader(String inputPath) {
        input = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(inputPath));
            this.loadData();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void loadData() throws Exception {
        String line;
        while((line = reader.readLine()) != null) {
            input.add(line);
        }
    }
}
