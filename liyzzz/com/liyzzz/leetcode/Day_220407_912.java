package com.liyzzz.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2022/04/08 20:21:23
 * @description 数组排序 快速排序
 */
public class Day_220407_912 {

    public int[] sortArray(int[] nums) {
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 排序从开始位置数据到结束位置的数组
     *
     * @param nums  排序的数组
     * @param start 开始位置
     * @param end   结束位置 包含
     */
    private void sortArray(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = pivotSort(nums, start, end);
        sortArray(nums, start, pivot - 1);
        sortArray(nums, pivot + 1, end);
    }


    /**
     * 按照基准 左边小 右边大
     * @param nums  数组
     * @param start 开始位置
     * @param end   结束位置
     * @return 基准移动的位置
     */
    private int pivotSort(int[] nums, int start, int end) {
        int left = start + 1;
        int right = end;
        Random random = new Random();
        swap(nums,start, random.nextInt(end-start+1)+start);
        //基准值为 start
        while (left < right) {
            while (left < right && nums[left] < nums[start]) {
                left++;
            }
            while (left < right && nums[right] > nums[start]) {
                right--;
            }
            if (left < right) {
                swap(nums,left,right);
            }
        }
        if (left == right && nums[start] < nums[right]) {
            swap(nums,right-1,start);
            return right-1;
        }
        swap(nums,left,start);

        return left;
    }

    /**
     * 交换两个数
     * @param nums 数组
     * @param start 位置1
     * @param end 位置2
     */
    public  void swap(int[] nums,int start,int end){
        int num = nums[start];
        nums[start] = nums[end];
        nums[end] = num;
    }
    public static void main(String[] args) {

//        System.out.println(Arrays.toString(day_220407_912.sortArray(ints)));
    }
}
