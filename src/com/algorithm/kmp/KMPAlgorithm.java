package com.algorithm.kmp;

import java.util.Arrays;

/**
 * @author : chenqingsong
 * @date : 2019-07-28 21:55
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
      //  String str2 = "BBC";

        int[] next = kmpNext("ABCDABD");
    //    System.out.println(Arrays.toString(next));

        int index = kmpSearch(str1, str2, next);
        System.out.println("index " + index);
    }

    /**
     * //写出kmp搜索算法
     * @param str1  源字符串
     * @param str2  子串
     * @param next   next 部分匹配表，是子串对应的部分匹配表
     * @return
     */
    public static int kmpSearch(String str1, String str2, int[] next){
        //遍历
        for(int i = 0, j = 0; i < str1.length(); i++){
            //需要处理str1.charAt(i) != str2.charAt(j)
            //kmp算法核心点
            while(j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }

            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if(j == str2.length()){//找到了
                return i - j + 1;
            }
        }
        return -1;
    }

    //获取字符串的部分匹配值表
    public static int[] kmpNext(String dest){
        //创建一个next数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0; //如果字符创长度为1，部分匹配值就是0
        for(int i = 1, j = 0; i < dest.length(); i++){
            //当dest.charAt(i) == dest.charAt(j)条件满足时，部分匹配就+1
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }else{
                //从next[j-1]获取新的j,直到dest.charAt(i) == dest.charAt(j)成立时退出
                //kmp算法的核心
                while (j > 0 && dest.charAt(i) != dest.charAt(j)){
                    j = next[j - 1];
                }
            }
            next[i] = j;
        }
        return next;
    }

}
