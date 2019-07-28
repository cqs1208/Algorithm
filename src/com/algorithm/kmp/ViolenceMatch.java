package com.algorithm.kmp;

/**
 * 暴力匹配
 * @author : chenqingsong
 * @date : 2019-07-28 21:11
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你-";
        int index = violenceMatch(str1, str2);
        System.out.println("index " + index);
    }

    //暴力匹配
    public static int violenceMatch(String str1, String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2len = s2.length;

        int i = 0; //i索引指向s1
        int j = 0; //j索引指向s2
        while (i < s1Len && j < s2len){
            if(s1[i] == s2[j]){ //保证匹配时，不越界
                i++;
                j++;
            }else{ // 没有匹配成功
                //如果匹配失败，令i = i - (j - 1);j = 0;
                i = i - (j - 1);
                j = 0;
            }
        }
        //判断是否匹配成功
        if(j == s2len){
            return i - j;
        }else {
            return -1;
        }
    }
}
