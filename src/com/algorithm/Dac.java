package com.algorithm;

/**
 * 汉诺塔
 * @author : chenqingsong
 * @date : 2019-07-27 19:51
 */
public class Dac {
    public static void main(String[] args) {
        hanluota(5, 'A', 'B', 'C' );
    }

    public static void hanluota(int num, char a, char b, char c){
        //一个盘
        if(num == 1){
            System.out.println("第1个盘从 " + a + " -> " + c);
        }else{
            //如果大于等于2，看做两个盘
            //1，先把最上面的盘A-》B
            hanluota(num - 1, a, c, b);
            //把最下边的盘A——C
            System.out.println("第" + num + "个盘从 "  + a + " -> " + c);
            //把B的所有盘从B-
            hanluota(num - 1, b, a, c);
        }
    }
}
