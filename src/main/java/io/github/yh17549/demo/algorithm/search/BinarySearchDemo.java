package io.github.yh17549.demo.algorithm.search;

import java.util.Arrays;
import java.util.Random;

/**
 * @author xyh
 * @date 2018-09-22
 */
public class BinarySearchDemo {

    public static void main(String[] args) {
        /*
        二分查找
        前提: 元素需要有序排列
        时间复杂度: O(log n)
         */

        Random random = new Random();

        int[] intArrays = BinarySearchDemo.generateOrderedIntArray(random.nextInt(10) + 20);
        System.out.println("array:" + Arrays.toString(intArrays));

        int key = random.nextInt(100);
        System.out.println("key:" + key);
        int index = BinarySearchDemo.binarySearch(intArrays, key);
        System.out.println("index:" + index);
    }

    /**
     *
     * 生成有序的数组
     * @param arrayLength 数组长度
     * @return
     */
    private static int[] generateOrderedIntArray(int arrayLength) {
        int[] intArray = new int[arrayLength];

        Random random = new Random();

        int j = 0;
        for (int i = 0; i <= arrayLength - 1; i++) {
            // 生成 1~9 的随机数
            j = j + random.nextInt(9) + 1;
            intArray[i] = j;
        }
        return intArray;
    }

    private static int binarySearch(int[] intArrays, int key) {

        if (intArrays == null || intArrays.length == 0) {
            return -1;
        }

        int lowIndex = 0;
        int highIndex = intArrays.length - 1;

        while (lowIndex <= highIndex) {
            int mid = (lowIndex + highIndex) / 2;
            if (key < intArrays[mid]) {
                highIndex = mid - 1;
            } else if (intArrays[mid] < key) {
                lowIndex = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
