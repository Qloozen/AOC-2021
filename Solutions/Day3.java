package Solutions;

import java.util.ArrayList;
import java.util.List;

import Utilities.AOC;

public class Day3 extends AOC {

    public Day3() {
        super(3);
    }

    @Override
    public void puzzleA(List<String> input) {
        // Create 2d array of input
        int rowLength = input.get(0).length();
        int[][] binary = new int[input.size()][rowLength];
        for (int y = 0; y < input.size(); y ++) {
            String row = input.get(y);
            String[] bits = row.split("");
            for (int x = 0; x < bits.length; x ++) {
                binary[y][x] = Integer.parseInt(bits[x]);
            }
        }
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();

        // Solve
        for(int x = 0; x < rowLength; x ++) {
            int ones = 0;
            int zeros = 0;
            for(int y = 0; y < binary.length; y ++) {
                int bit = binary[y][x];
                if(bit== 0) {
                    zeros ++;
                } else {
                    ones ++;
                }
            }

            if(ones > zeros) {
                gamma.append("1");
                epsilon.append("0");
            } else {
                gamma.append("0");
                epsilon.append("1");
            }
        }
        int gammaDecimal = Integer.parseInt(gamma.toString(),2);
        int epsilionDecimal = Integer.parseInt(epsilon.toString(),2);
        System.out.println(String.format("Gamma rate binary: %s = %d, Epsilon rate binary: %s = %d, multiply = %d", gamma.toString(), gammaDecimal, epsilon.toString(), epsilionDecimal, (gammaDecimal * epsilionDecimal)));
    }

    @Override
    public void puzzleB(List<String> input) {
        // OMG SPAGETTI CODE
        oxygen(input);
        co2(input);
    }

    public void oxygen(List<String> input) {
        List<String> oxygenInput = new ArrayList<>(input);
        List<String> oxygenFilter = new ArrayList<>();
        int increment = 0;
        while(oxygenInput.size() > 1) {
            String majority = "";
            int ones = 0;
            int zeros = 0;
            for (String string : oxygenInput) {
                if(string.charAt(increment) == '0') {
                    zeros ++;
                } else {
                    ones ++;
                }
            }
    
            if(ones > zeros) {
                majority = "ones";
            } else if(ones == zeros) {
                if(oxygenInput.size() > 2) {
                    for (String s : oxygenInput) {
                        if(s.charAt(increment) == '1') {
                            oxygenFilter.add(s);
                        }
                    }
                } else if(oxygenInput.get(0).charAt(increment) == '1') {
                    String value = oxygenInput.get(0);
                    System.out.println(String.format("Oxygen: %s =  %d", value, Integer.parseInt(value, 2)));
                } else {
                    String value = oxygenInput.get(1);
                    System.out.println(String.format("Oxygen: %s =  %d", value, Integer.parseInt(value, 2)));
                }
            } else {
                majority = "zeros";
            }
    
            for (String string : oxygenInput) {
                if(string.charAt(increment) == '0' && majority == "zeros") {
                    oxygenFilter.add(string);
                } else if (string.charAt(increment) == '1' && majority == "ones"){
                    oxygenFilter.add(string);
                }
            }

            oxygenInput = new ArrayList<>();
            for (String s : oxygenFilter) {
                oxygenInput.add(s);
            }
            oxygenFilter = new ArrayList<>();
            increment ++;
        }
    }
    
    public void co2(List<String> input) {
        List<String> oxygenInput = new ArrayList<>(input);
        List<String> oxygenFilter = new ArrayList<>();
        int increment = 0;
        while(oxygenInput.size() > 1) {
            String minority = "";
            int ones = 0;
            int zeros = 0;
            for (String string : oxygenInput) {
                if(string.charAt(increment) == '0') {
                    zeros ++;
                } else {
                    ones ++;
                }
            }
    
            if(ones > zeros) {
                minority = "zeros";
            } else if(ones == zeros) {
                if(oxygenInput.size() > 2) {
                    for (String s : oxygenInput) {
                        if(s.charAt(increment) == '0') {
                            oxygenFilter.add(s);
                        }
                    }
                } else if(oxygenInput.get(0).charAt(increment) == '0') {
                    String value = oxygenInput.get(0);
                    System.out.println(String.format("Oxygen: %s =  %d", value, Integer.parseInt(value, 2)));
                } else {
                    String value = oxygenInput.get(1);
                    System.out.println(String.format("Oxygen: %s =  %d", value, Integer.parseInt(value, 2)));
                }
            } else {
                minority = "ones";
            }
    
            for (String string : oxygenInput) {
                if(string.charAt(increment) == '0' && minority == "zeros") {
                    oxygenFilter.add(string);
                } else if (string.charAt(increment) == '1' && minority == "ones"){
                    oxygenFilter.add(string);
                }
            }

            oxygenInput = new ArrayList<>();
            for (String s : oxygenFilter) {
                oxygenInput.add(s);
            }
            oxygenFilter = new ArrayList<>();
            increment ++;
        }
    }
    
}
