package Solutions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Utilities.AOC;

public class Day5 extends AOC{

    public Day5() {
        super(5);
    }

    @Override
    public void puzzleA(List<String> input) {
        Map<Coordinate, Integer> lines = new HashMap<>();

        // Filter only horizontal and vertical lines
        for (String lineSegment : input) {
            String[] parts = lineSegment.split(",| -> ");
            int x1 = Integer.parseInt(parts[0]);
            int y1 = Integer.parseInt(parts[1]);
            int x2 = Integer.parseInt(parts[2]);
            int y2 = Integer.parseInt(parts[3]);
            if(x1 == x2) {
                int lo = Math.min(y1, y2);
                int high = Math.max(y1, y2);
                for (int i = lo; i <= high; i++) {
                    Coordinate position = new Coordinate(x1, i);
                    if(lines.containsKey(position)) {
                        lines.put(position, (lines.get(position) + 1));
                    } else {
                        lines.put(position, 1);
                    }
                }
            } else if(y1 == y2) {
                int lo = Math.min(x1, x2);
                int high = Math.max(x1, x2);
                for (int i = lo; i <= high; i++) {
                    Coordinate position = new Coordinate(i, y1);
                    if(lines.containsKey(position)) {
                        lines.put(position, (lines.get(position) + 1));
                    } else {
                        lines.put(position, 1);
                    }
                }
            }
        }
        
        int counter = 0;
        for (int overlap: lines.values()) {
            if(overlap > 1) counter ++;
        }
        System.out.println(counter);
    }

    @Override
    public void puzzleB(List<String> input) {
        Map<Coordinate, Integer> lines = new HashMap<>();

        // Filter only horizontal and vertical lines
        for (String lineSegment : input) {
            String[] parts = lineSegment.split(",| -> ");
            int x1 = Integer.parseInt(parts[0]);
            int y1 = Integer.parseInt(parts[1]);
            int x2 = Integer.parseInt(parts[2]);
            int y2 = Integer.parseInt(parts[3]);
            if(x1 == x2) {
                int lo = Math.min(y1, y2);
                int high = Math.max(y1, y2);
                for (int i = lo; i <= high; i++) {
                    Coordinate position = new Coordinate(x1, i);
                    if(lines.containsKey(position)) {
                        lines.put(position, (lines.get(position) + 1));
                    } else {
                        lines.put(position, 1);
                    }
                }
            } else if(y1 == y2) {
                int lo = Math.min(x1, x2);
                int high = Math.max(x1, x2);
                for (int i = lo; i <= high; i++) {
                    Coordinate position = new Coordinate(i, y1);
                    if(lines.containsKey(position)) {
                        lines.put(position, (lines.get(position) + 1));
                    } else {
                        lines.put(position, 1);
                    }
                }
            } else {
                // Top left -> bottom right
                if(y1 < y2 && x1 < x2) {
                    int x = x1;
                    for (int y = y1; y <= y2; y++) {
                        Coordinate position = new Coordinate(x, y);
                        if(lines.containsKey(position)) {
                            lines.put(position, (lines.get(position) + 1));
                        } else {
                            lines.put(position, 1);
                        }
                        x ++;
                    }
                }

                // bottom right -> top left
                else if(y1 > y2 && x1 > x2) {
                    int x = x1;
                    for (int y = y1; y2 <= y; y--) {
                        Coordinate position = new Coordinate(x, y);
                        if(lines.containsKey(position)) {
                            lines.put(position, (lines.get(position) + 1));
                        } else {
                            lines.put(position, 1);
                        }
                        x --;
                    }
                }

                // Top right -> bottom left
                else if(y1 < y2 && x1 > x2) {
                    int x = x1;
                    for (int y = y1; y2 >= y; y++) {
                        Coordinate position = new Coordinate(x, y);
                        if(lines.containsKey(position)) {
                            lines.put(position, (lines.get(position) + 1));
                        } else {
                            lines.put(position, 1);
                        }
                        x --;
                    }
                }

                // Bottom left -> top right
                else if(y1 > y2 && x1 < x2) {
                    int x = x1;
                    for (int y = y1; y2 <= y; y--) {
                        Coordinate position = new Coordinate(x, y);
                        if(lines.containsKey(position)) {
                            lines.put(position, (lines.get(position) + 1));
                        } else {
                            lines.put(position, 1);
                        }
                        x ++;
                    }
                }
            }
        }
        
        int counter = 0;
        for (int overlap: lines.values()) {
            if(overlap > 1) counter ++;
        }
        System.out.println(counter);
    }

    public class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getEnclosingInstance().hashCode();
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Coordinate other = (Coordinate) obj;
            if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
                return false;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }
        private Day5 getEnclosingInstance() {
            return Day5.this;
        }
        
        
    }

    
}