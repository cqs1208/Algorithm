package com.algorithm;

/**
 * 二分查找
 * @author : chenqingsong
 * @date : 2019-07-27 19:25
 */
public class BinarySearchNotecur {
    public static void main(String[] args) {
        int arr[] = {1,3,8,10,11,67,100};
        int index = binarySearch(arr, -10);
        System.out.println("index : " + index);

    }

    /**
     * 二分查找的非递归实现
     * @param arr 贷查找的数组  arr升序
     * @param target 需要查找的数
     * @return
     */
    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){//说明可以继续查找
            int mid = (left + right) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                right = mid - 1; //需要向左边查找
            }else {
                left = mid + 1;//需要向右查找
            }
        }
        return -1;
    }
}
