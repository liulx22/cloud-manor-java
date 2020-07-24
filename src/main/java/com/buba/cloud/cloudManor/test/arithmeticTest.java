package com.buba.cloud.cloudManor.test;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName arithmeticTest
 * @Description
 * @Created by Administrator on 2020/7/24 14:06
 * @Version 1.0
 **/
public class arithmeticTest {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arrays = new int[10];
        int temp;
        for (int i = 0; i < arrays.length; i++) {//随机生成10个随机数
            arrays[i] = 20 + rand.nextInt(31);
            System.out.println(arrays[i]);
        }

        //冒泡排序
        for (int i = 0; i < arrays.length; i++){//最外层循环
            for (int j = 0; j < arrays.length - 1 - i; j++){//里层循环
                if (arrays[j + 1] < arrays[j]) {//比较
                    temp = arrays[j + 1];
                    arrays[j + 1] = arrays[j];
                    arrays[j] = temp;
                }
            }
        }
        //遍历排好序的数组
        System.out.print("排序后的:");
        for(int array:arrays){
            System.out.print(array+" ");
        }

    }
}
