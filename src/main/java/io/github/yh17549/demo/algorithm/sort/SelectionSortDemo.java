package io.github.yh17549.demo.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author xyh
 * @date 2018-09-25
 */
public class SelectionSortDemo {

    public static void main(String[] args) {

        /*
        选择排序
        时间复杂度: O(n^2)
         */

        int[] intArray = generateUnorderedIntArray(20);

        System.out.println("array:" + Arrays.toString(intArray));
        int[] orderedIntArray = selectionSort(intArray);
        System.out.println("orderedIntArray:" + Arrays.toString(orderedIntArray));

    }

    private static int[] generateUnorderedIntArray(int arrayLength) {
        int[] intArray = new int[arrayLength];

        Random random = new Random();

        for (int i = 0; i <= arrayLength - 1; i++) {
            intArray[i] = random.nextInt(100);
        }

        return intArray;
    }

    private static int[] selectionSort(int[] intArray) {

        int minIndex = 0;
        for (int i = 0; i < intArray.length; i++) {
            minIndex = i;

            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[j] < intArray[minIndex]) {
                    minIndex = j;
                }
            }

            // exchange
            int temp = intArray[i];
            intArray[i] = intArray[minIndex];
            intArray[minIndex] = temp;

        }
        return intArray;
    }

}
