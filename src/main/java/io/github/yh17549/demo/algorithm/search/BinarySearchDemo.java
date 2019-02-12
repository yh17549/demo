package io.github.yh17549.demo.algorithm.search;

import io.github.yh17549.demo.algorithm.util.ArrayUtils;
import io.github.yh17549.demo.algorithm.util.SearchUtils;

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

        int[] intArrays = ArrayUtils.generateOrderedIntArray(random.nextInt(10) + 20);
        System.out.println("array:" + Arrays.toString(intArrays));

        int key = random.nextInt(100);
        System.out.println("key:" + key);
        int index = SearchUtils.binarySearch(intArrays, key);
        System.out.println("index:" + index);
    }

}
