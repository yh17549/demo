package io.github.yh17549.demo.algorithm.sort;

import io.github.yh17549.demo.algorithm.util.ArrayUtils;
import io.github.yh17549.demo.algorithm.util.SortUtils;

import java.util.Arrays;

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

        int[] intArray = ArrayUtils.generateUnorderedIntArray(20);

        System.out.println("array:" + Arrays.toString(intArray));
        int[] orderedIntArray = SortUtils.selectionSort(intArray);
        System.out.println("orderedIntArray:" + Arrays.toString(orderedIntArray));
    }

}
