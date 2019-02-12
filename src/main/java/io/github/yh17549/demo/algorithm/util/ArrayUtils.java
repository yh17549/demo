package io.github.yh17549.demo.algorithm.util;

import java.util.Random;

/**
 * @author xyh
 * @date 2019-02-12
 */
public class ArrayUtils {

    /**
     *
     * 生成有序的数组
     * @param arrayLength 数组长度
     * @return
     */
    public static int[] generateOrderedIntArray(int arrayLength) {
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


    /**
     * 生成无序的数组
     * @param arrayLength
     * @return
     */
    public static int[] generateUnorderedIntArray(int arrayLength) {
        int[] intArray = new int[arrayLength];

        Random random = new Random();

        for (int i = 0; i <= arrayLength - 1; i++) {
            // 生成 0~99 之间的随机数
            intArray[i] = random.nextInt(100);
        }

        return intArray;
    }

}
