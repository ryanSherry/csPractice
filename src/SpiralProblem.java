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

        public void printArray(int counter, int rowStart, int rowEnd, int colStart, int colEnd){

        if (counter == numCol * numRows) {
            return;
        }

//        int rowStart = 0;
//        int rowEnd = numRows;
//        int colStart = 0;
//        int colEnd = numCol;


            for(int i = colStart; i < colEnd; i++) {
                System.out.print(data[rowStart][i]);
                counter++;
            }


            for(int i = rowStart+1; i < rowEnd; i++) {
                System.out.print(data[i][rowEnd - 1]);
                counter++;
            }

            for(int i = colEnd - 1 - 1; i >= colStart; i--) {
                System.out.print(data[rowEnd - 1][i]);
                counter++;
            }

            for(int i = rowEnd - 1 - 1; i > rowStart; i--) {
                System.out.print(data[i][colStart]);
                counter++;
            }

            printArray(counter,rowStart + 1, rowEnd - 1, colStart + 1, colEnd - 1);
        }

        public static void main(String[] args) {
            SpiralProblem spiralProblem = new SpiralProblem(4,4);
            spiralProblem.printArray(0, 0, 4, 0, 4);
        }

}
