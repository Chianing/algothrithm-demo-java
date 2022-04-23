package com.chianing.algorithm;

import java.util.Arrays;

/**
 * 排序算法
 */
public class Sort {

    /**
     * 冒泡排序
     */
    public int[] bubbleSort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }

        int tmp;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

        return nums;
    }

    /**
     * 选择排序
     * <p>
     * 每次遍历 将列表中未处理元素中最小的元素放到列表头部
     */
    public int[] selectionSort(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return nums;
        }

        for (int i = 0; i < length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int tmpNum = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = tmpNum;
            }
        }

        return nums;
    }

    /**
     * 直接插入排序
     * <p>
     * 从最后一个数开始向前循环 如果插入数小于当前数 就将当前数向后移动一位
     * 将当前数放置到空着的位置
     */
    public int[] insertSort(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return nums;
        }

        int currentNum;
        int sortedIndex;

        for (int i = 1; i < length; i++) {
            currentNum = nums[i];
            sortedIndex = i - 1;

            while (sortedIndex >= 0 && currentNum < nums[sortedIndex]) {
                nums[sortedIndex + 1] = nums[sortedIndex];
                sortedIndex--;
            }

            nums[sortedIndex + 1] = currentNum;

        }

        return nums;

    }

    /**
     * 希尔排序
     * <p>
     * 把记录按下标的一定增量分组 对每组使用直接插入排序算法排序
     * 随着增量逐渐减少 每组包含的关键词越来越多 当增量减至 1 时 整个文件恰被分成一组 算法便终止
     */
    public int[] shellSort(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return nums;
        }

        int gap = length / 2;
        int currentNum, preIndex;

        while (gap != 0) {
            for (int i = gap; i < length; i++) {
                currentNum = nums[i];
                preIndex = i - gap;

                while (preIndex >= 0 && currentNum < nums[preIndex]) {
                    nums[preIndex + gap] = nums[preIndex];
                    preIndex -= gap;
                }

                nums[preIndex + gap] = currentNum;
            }

            gap /= 2;
        }

        return nums;

    }

    /**
     * 归并排序
     * <p>
     * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序
     */
    public int[] mergeSort(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return nums;
        }

        int mid = length / 2;
        int[] leftArr = Arrays.copyOfRange(nums, 0, mid);
        int[] rightArr = Arrays.copyOfRange(nums, mid, nums.length);

        return merge(mergeSort(leftArr), mergeSort(rightArr));
    }

    private int[] merge(int[] leftArr, int[] rightArr) {
        int[] result = new int[leftArr.length + rightArr.length];
        for (int i = 0, leftIndex = 0, rightIndex = 0; i < result.length; i++) {
            if (leftIndex >= leftArr.length) {
                result[i] = rightArr[rightIndex++];
            } else if (rightIndex >= rightArr.length) {
                result[i] = leftArr[leftIndex++];
            } else if (leftArr[leftIndex] < rightArr[rightIndex]) {
                result[i] = leftArr[leftIndex++];
            } else {
                result[i] = rightArr[rightIndex++];
            }
        }
        return result;
    }

}
