package io.github.yh17549.demo.algorithm.util;


/**
 * @author xyh
 * @date 2019-02-12
 */
public class SortUtils {

    /**
     * 选择排序
     * @param intArray
     * @return
     */
    public static int[] selectionSort(int[] intArray) {

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

    /**
     * 冒泡排序
     * @param intArray
     * @return
     */
    public static int[] bubbleSort(int[] intArray) {

        for (int i = 0; i < intArray.length; i++) {

            // -1 为了防止溢出
            for (int j = 0; j < intArray.length -i -1 ; j++) {
                if (intArray[j]>intArray[j+1]){
                    int temp = intArray[j];
                    intArray[j] = intArray[j+1];
                    intArray[j+1] = temp;
                }
            }
        }
        return intArray;
    }

}
