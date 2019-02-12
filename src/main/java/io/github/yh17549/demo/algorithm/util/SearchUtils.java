package io.github.yh17549.demo.algorithm.util;

/**
 * @author xyh
 * @date 2019-02-12
 */
public class SearchUtils {

    /**
     * 二分查找
     * @param intArrays
     * @param key
     * @return
     */
    public static int binarySearch(int[] intArrays, int key) {

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
