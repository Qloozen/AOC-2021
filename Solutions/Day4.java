package Solutions;

import java.util.ArrayList;
import java.util.List;

import Utilities.AOC;

public class Day4 extends AOC {

    public Day4() {
        super(4);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void puzzleA(List<String> input) {
        System.out.println("PUZZLE A");
        String[] stringNums = input.get(0).split(",");
        input.remove(0);

        int[] searchNums = new int[stringNums.length];
        for (int i = 0; i < stringNums.length; i ++) {
            searchNums[i] = Integer.parseInt(stringNums[i]);
        }

        // Loop boards
        boolean foundWinner = false;
        int index = 1; // leap to each board
        int searchIndex = 4;
        while(!foundWinner) {
            int[][] board = new int[5][5];
            
            // Convert board to int[][]
            for (int y = index; y < (index + 5); y++) {
                String[] stringRow = input.get(y).trim().split("\\s+");
                for (int x = 0; x < stringRow.length; x ++) {
                    board[y - index][x] = Integer.parseInt(stringRow[x]);
                }
            }
            
            // Loop horizontal
            int unmarkedSum = 0;
            int lastNumberCalled = 0;
            for (int y = 0; y < 5; y++) {
                int sameNumbers = 0;
                for (int x = 0; x < 5; x++) {
                    // Loop through range of numbers
                    boolean isMatch = false;
                    int checkNum = board[y][x];
                    for (int j2 = 0; j2 < searchIndex; j2++) {
                        int matchNum = searchNums[j2];
                        if( checkNum == matchNum) {
                            sameNumbers ++;
                            isMatch = true;
                            if(sameNumbers == 5) { // found winner, but need to go on for unmarked Sum
                                System.out.println("Last number called: " + searchNums[searchIndex - 1]);
                                lastNumberCalled = searchNums[searchIndex - 1];
                                foundWinner = true;
                            }
                        }
                    }
                    if(!isMatch) {
                        unmarkedSum += board[y][x];
                    }
                }
            }

            unmarkedSum = 0;
              
            // Loop vertical
            for (int x = 0; x < 5; x++) {
                int sameNumbers = 0;
                for (int y = 0; y < 5; y++) {
                    // Loop through range of numbers
                    boolean isMatch = false;
                    int checkNum = board[y][x];
                    for (int j2 = 0; j2 < searchIndex; j2++) {
                        int matchNum = searchNums[j2];
                        if( checkNum == matchNum) {
                            sameNumbers ++;
                            isMatch = true;
                            if(sameNumbers == 5) { // found winner, but need to go on for unmarked Sum
                                System.out.println("Last number called: " + searchNums[searchIndex - 1]);
                                lastNumberCalled = searchNums[searchIndex - 1];
                                foundWinner = true;
                            }
                        }
                    }
                    if(!isMatch) {
                        unmarkedSum += board[y][x];
                    }
                }
            }

            if(foundWinner) System.out.println("Winner! unmarked: " + unmarkedSum + ", last number called:" + lastNumberCalled + ", multiply: " + (lastNumberCalled * unmarkedSum));
            
            //Increase index by 6 (5 + white space)
            if ((index + 6) >  input.size()) {
                index = 1;
                searchIndex ++;
            } else {
                index += 6;
            }
        }
        
    }

    @Override
    public void puzzleB(List<String> input) {
        System.out.println("PUZZLE B");
        String[] stringNums = input.get(0).split(",");
        input.remove(0);

        int[] searchNums = new int[stringNums.length];
        for (int i = 0; i < stringNums.length; i ++) {
            searchNums[i] = Integer.parseInt(stringNums[i]);
        }

        // Loop boards
        int tableCount = input.size() / 6;
        int winnerCount = 0;
        int index = 1; // leap to each board
        int searchIndex = 4;
        List<Integer> winners = new ArrayList<>();
        while(winnerCount < tableCount) {

            if(!winners.contains(index)) {
                int[][] board = new int[5][5];
            
                // Convert board to int[][]
                for (int y = index; y < (index + 5); y++) {
                    String[] stringRow = input.get(y).trim().split("\\s+");
                    for (int x = 0; x < stringRow.length; x ++) {
                        board[y - index][x] = Integer.parseInt(stringRow[x]);
                    }
                }
                
                // Loop horizontal
                int unmarkedSum = 0;
                int lastNumberCalled = 0;
                boolean won = false;
                for (int y = 0; y < 5; y++) {
                    int sameNumbers = 0;
                    for (int x = 0; x < 5; x++) {
                        // Loop through range of numbers
                        boolean isMatch = false;
                        int checkNum = board[y][x];
                        for (int j2 = 0; j2 < searchIndex; j2++) {
                            int matchNum = searchNums[j2];
                            if( checkNum == matchNum) {
                                sameNumbers ++;
                                isMatch = true;
                                if(sameNumbers == 5) { // found winner, but need to go on for unmarked Sum
                                    lastNumberCalled = searchNums[searchIndex - 1];
                                    winnerCount ++;
                                    winners.add(index);
                                    won = true;
                                }
                            }
                        }
                        if(!isMatch) {
                            unmarkedSum += board[y][x];
                        }
                    }
                }


                if(!won) {
                    unmarkedSum = 0;
                  
                    // Loop vertical
                    for (int x = 0; x < 5; x++) {
                        int sameNumbers = 0;
                        for (int y = 0; y < 5; y++) {
                            // Loop through range of numbers
                            boolean isMatch = false;
                            int checkNum = board[y][x];
                            for (int j2 = 0; j2 < searchIndex; j2++) {
                                int matchNum = searchNums[j2];
                                if( checkNum == matchNum) {
                                    sameNumbers ++;
                                    isMatch = true;
                                    if(sameNumbers == 5) { // found winner, but need to go on for unmarked Sum
                                        lastNumberCalled = searchNums[searchIndex - 1];
                                        winnerCount ++;
                                        winners.add(index);
                                    }
                                }
                            }
                            if(!isMatch) {
                                unmarkedSum += board[y][x];
                            }
                        }
                    }
                }

    
                if(winnerCount == tableCount) System.out.println("Winner! unmarked: " + unmarkedSum + ", last number called:" + lastNumberCalled + ", multiply: " + (lastNumberCalled * unmarkedSum));
                
                //Increase index by 6 (5 + white space)
                if ((index + 6) >  input.size()) {
                    index = 1;
                    searchIndex ++;
                } else {
                    index += 6;
                }
            }
            else {
                //Increase index by 6 (5 + white space)
                if ((index + 6) >  input.size()) {
                    index = 1;
                    searchIndex ++;
                } else {
                    index += 6;
                }
            }
        }
    }
    
}
