package safety;


import java.util.Arrays;

public class SafetyInNumbers {

    private int number;
    private int sumOfPoints;
    private int points[];
    private float result[];

    private Kattio io = new Kattio(System.in, System.out);

    public static void main(String[] args) {
        SafetyInNumbers sf = new SafetyInNumbers();
        sf.getInput();
    }

    private void getInput() {


        int cases = io.getInt();

        for (int t = 0; t < cases; t++) {
            sumOfPoints = 0;
            number = io.getInt();
            points = new int[number];
            result = new float[number];
            for (int i = 0; i < number; i++) {
                points[i] = io.getInt();
                sumOfPoints += points[i];
            }
            calc(t);
        }

        io.close();
    }

    private void calc(int in) {
        int[] tempArray = new int[number + 1];
        System.arraycopy(points, 0, tempArray, 0, number);
        tempArray[number] = 2 * sumOfPoints;
        Arrays.sort(tempArray);
        float val = 0;
        float check = 0;
        for (int i = 0; i < number; i++) {
            float count = (i + 1) * (tempArray[i + 1] - tempArray[i]) / ((float) sumOfPoints);
            if (count + val > 1) {
                check = tempArray[i] + (1 - val) * ((float) sumOfPoints) / (i + 1);
                break;
            } else {
                val += count;
            }

        }
        for (int n = 0; n < number; n++) {
            result[n] = (check - points[n]) / ((float) sumOfPoints);
            if (result[n] < 0) {
                result[n] = 0;
            }
        }
        io.print("Case #" + (in + 1) + ": ");
        for (int i = 0; i < number; i++) {
            String res = 100 * result[i] + " ";
            io.print(res);

        }
        io.println();
    }

}


