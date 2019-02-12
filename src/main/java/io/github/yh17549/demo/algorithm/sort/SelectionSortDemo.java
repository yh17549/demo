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
        选择排序 : 每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，
        时间复杂度: O(n^2)
         */

        int[] intArray = SelectionSortDemo.generateUnorderedIntArray(20);

        System.out.println("array:" + Arrays.toString(intArray));
        int[] orderedIntArray = SelectionSortDemo.selectionSort(intArray);
        System.out.println("orderedIntArray:" + Arrays.toString(orderedIntArray));
    }

    /**
     * 生成无序的数组
     * @param arrayLength
     * @return
     */
    private static int[] generateUnorderedIntArray(int arrayLength) {
        int[] intArray = new int[arrayLength];

        Random random = new Random();

        for (int i = 0; i <= arrayLength - 1; i++) {
            // 生成 0~99 之间的随机数
            intArray[i] = random.nextInt(100);
        }

        return intArray;
    }

    /**
     * 选择排序
     * @param intArray
     * @return
     */
    private static int[] selectionSort(int[] intArray) {

        int minIndex = 0;
        for (int i = 0; i < intArray.length; i++) {
            minIndex = i;

            // 找到值最小的元素的下标
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[j] < intArray[minIndex]) {
                    minIndex = j;
                }
            }

            // minIndex 没有改变则不处理
            if (minIndex != i){
                // exchange
                int temp = intArray[i];
                intArray[i] = intArray[minIndex];
                intArray[minIndex] = temp;
            }
        }
        return intArray;
    }

}
