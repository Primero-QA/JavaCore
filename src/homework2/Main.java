package homework2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        arraySumCheck(DataProvider.goodArray);
//        arraySumCheck(DataProvider.badWidthArray);
//        arraySumCheck(DataProvider.badDepthArray);
//        arraySumCheck(DataProvider.badContentArray);
    }



    public static void arraySumCheck(String[][] inArray) throws MyArraySizeException, MyArrayDataException {
        if (inArray.length != 4) {
            throw new MyArraySizeException("Array is not 4x4 width!");
        } else {
            for (int i = 0; i < inArray.length; i++) {
                if (inArray[i].length != 4) {
                    throw new MyArraySizeException("Array is not 4x4 depth!");
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < inArray.length; i++) {
            for (int j = 0; j < inArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(inArray[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException("Provided data is not integer in: " +i + ";" + j);
                }
            }
        }
        System.out.println("Sum is: " + sum);
    }

//    public static void sumArray (String inArray[][]) {
//        for (int i = 0; i < inArray.length; i++) {
//            for (int j = 0; j < inArray[i].length; j++) {
//                      int a = Integer.parseInt(inArray[i][j]);
//
//            }
//        }
//    }
}

