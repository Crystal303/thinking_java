package chap16.Exercise;

import java.util.Arrays;

public class Ex3 {
    public static double[][] createArray(int size1, int size2,
                                         double start, double end) {
        if (end <= start) {
            System.out.println("Start must be less than end");
            return null;
        }
        if (size1 < 1 || size2 < 1) {
            return null;
        }
        double[][] result = new double[size1][size2];
        result[0] = new double[size2];
        for(int j = 0; j < size2; j++) {
            result[0][j] = (start + ((double) j / (size2 - 1)) * (end - start));
        }
        if(size1 == 1) 	return result;
        else
            for(int i = 1; i < size1; i++) {
                result[i] = new double[size2];
                for(int j = 0; j < size2; j++) {
                    result[i][j] = start +
                            ((double)j/(size2 - 1))*(((double)j + (double)i)/(size2 - 1 + i)) *
                                    (end - start);
                }
            }
        return result;
    }

    public static void printArray(double[][] da) {
        System.out.println(Arrays.deepToString(da));
    }

    public static void main(String[] args) {
        printArray(createArray(0,2,4,5));
        printArray(createArray(2,3,5,4));
        printArray(createArray(1,2,5,10));
        printArray(createArray(2,2,5,10));
        printArray(createArray(3,3,5,10));
        printArray(createArray(3,5,10,20));
    }
}
