public class SpiralProblem {
    private int[][] data;
    private int numRows;
    private int numCol;
    private int commaLimit;


    public SpiralProblem(int numRows, int numCol) {
        this.numRows = numRows;
        this.numCol = numCol;
        this.data = new int[numRows][numCol];
        this.commaLimit = numCol * numRows - 1;
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                data[i][j] = counter;
                counter++;
            }
        }
    }

    private void printHelper(int counter, int value) {
        if (counter < commaLimit) {
            System.out.print(value + ", ");
        } else {
            System.out.print(value);
        }
    }

        public void printArray(int counter, int start, int finish){

        //base case
        if (counter == numCol * numRows) {
            return;
        }

            for(int i = start; i < finish; i++) {
                printHelper(counter, data[start][i]);
                counter++;
            }


            for(int i = start+1; i < finish; i++) {
                printHelper(counter, data[i][finish - 1]);
                counter++;
            }

            for(int i = finish - 1 - 1; i >= start; i--) {
                printHelper(counter, data[finish - 1][i]);
                counter++;
            }

            for(int i = finish - 1 - 1; i > start; i--) {
                printHelper(counter, data[i][start]);
                counter++;
            }

            printArray(counter,start + 1, finish - 1);
        }

        public static void main(String[] args) {
            SpiralProblem spiralProblem = new SpiralProblem(4,4);
            spiralProblem.printArray(0, 0, 4);
        }

}
