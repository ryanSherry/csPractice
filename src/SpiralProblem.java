public class SpiralProblem {
    private int[][] data;
    private int numRows;
    private int numCol;
    public SpiralProblem(int numRows, int numCol) {
        this.numRows = numRows;
        this.numCol = numCol;
        this.data = new int[numRows][numCol];
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                data[i][j] = counter;
                counter++;
            }
        }
    }

        public void printArray(int counter, int start, int finish){

        if (counter == numCol * numRows) {
            return;
        }

            for(int i = start; i < finish; i++) {
                if(counter == numCol * numRows - 1) {
                    System.out.print(data[start][i]);
                } else {
                    System.out.print(data[start][i] + ", ");
                }
                counter++;
            }


            for(int i = start+1; i < finish; i++) {
                if(counter == numCol * numRows - 1) {
                    System.out.print(data[i][finish - 1]);
                } else {
                    System.out.print(data[i][finish - 1] + ", ");
                }
                counter++;
            }

            for(int i = finish - 1 - 1; i >= start; i--) {
                if(counter == numCol * numRows - 1) {
                    System.out.print(data[finish - 1][i]);
                } else {
                    System.out.print(data[finish - 1][i] + ", ");
                }
                counter++;
            }

            for(int i = finish - 1 - 1; i > start; i--) {
                if (counter == numCol * numRows - 1) {
                    System.out.print(data[i][start]);
                } else {
                    System.out.print(data[i][start] + ", ");
                }
                counter++;
            }

            printArray(counter,start + 1, finish - 1);
        }

        public static void main(String[] args) {
            SpiralProblem spiralProblem = new SpiralProblem(4,4);
            spiralProblem.printArray(0, 0, 4);
        }

}
