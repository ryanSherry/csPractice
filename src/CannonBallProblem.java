public class CannonBallProblem {
    int h;

    public CannonBallProblem(int h) {
        if(h == 0) {
            System.out.println("_");
        }

        this.h = h;
    }

    public int[] generatePyrimidData() {
        int[] a = new int[h];
        for (int i = 0; i < a.length; i++) {
            a[i] = i*2+1;
        }
        return a;
    }

    private String spacesHelper(int h) {
        String result = "";
        for(int i = 0; i < h; i++) {
            result += " ";
        }
        return result;
    }

    public void printPyrimid(int[] a) {
        for (int i = 0; i < a.length; i++) {
            String stringToPrint = "";

            for (int j = 0; j < a[i]; j++) {
                stringToPrint += "O";
            }

            System.out.println(spacesHelper(h - i) + stringToPrint);
        }
    }

    public void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 12; i++) {
            CannonBallProblem cannonBallProblem = new CannonBallProblem(i);
            int[] cannonBallData = cannonBallProblem.generatePyrimidData();
            cannonBallProblem.printPyrimid(cannonBallData);
        }

    }
}
/*
  0
 000
00000
        */