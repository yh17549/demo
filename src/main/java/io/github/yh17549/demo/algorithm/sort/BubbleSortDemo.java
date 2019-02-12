package io.github.yh17549.demo.algorithm.sort;

import io.github.yh17549.demo.algorithm.util.ArrayUtils;
import io.github.yh17549.demo.algorithm.util.SortUtils;

import java.util.Arrays;

/**
 * @author xyh
 * @date 2019-02-12
 */
public class BubbleSortDemo {

    public static void main(String[] args){

        int[] intArray = ArrayUtils.generateUnorderedIntArray(20);

        System.out.println("array:" + Arrays.toString(intArray));
        int[] orderedIntArray = SortUtils.bubbleSort(intArray);
        System.out.println("orderedIntArray:" + Arrays.toString(orderedIntArray));
    }


}
