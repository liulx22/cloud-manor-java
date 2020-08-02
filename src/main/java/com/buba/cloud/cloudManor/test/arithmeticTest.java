package com.buba.cloud.cloudManor.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @ClassName arithmeticTest
 * @Description
 * @Created by Administrator on 2020/7/24 14:06
 * @Version 1.0
 **/
public class arithmeticTest {

    public static void main(String[] args) throws ParseException {

       /* int[] arr = {12,11,14,19,17,16,15};*/
        /*Random r = new Random();
        int[] arr =new int[80000];
        for (int o=0;o<arr.length;o++){
            arr[o]= r.nextInt(80000);
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式

        long millionSeconds = df.parse(df.format(new Date())).getTime();//毫秒
        System.out.println("kai="+millionSeconds);
        kuaishu(arr,0,arr.length-1);
        *//*maopao(arr);//冒泡*//*
        long millionSeconds2 = df.parse(df.format(new Date())).getTime();//毫秒
        System.out.println("jie="+millionSeconds2);
        System.out.println(millionSeconds2-millionSeconds);*/
        String str1="BBC ABCDAB ABCDABCDABDE";
        String str2="ABCDABD";
        int s=baolipipai(str1,str2);
        System.out.println(s);
    }
    /*字符串匹配  暴力匹配算法*/
    public static int baolipipai(String str1,String str2){
        //声明两个，循环str1
        for(int i=0,j=0;i<str1.length();i++){
            if(j>0 && str1.charAt(i)!=str2.charAt(j)){
                i=i-j;
                j=0;
            }else if(str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if(j==str2.length()){
                return i-(j-1);
            }
        }
        return -1;
    }
    /*快速*/
    public static void kuaishu(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int stand=arr[right];//选择值
        int l=left;
        int r=right;
        int temp=0;//临时标量
        while (l<r){//当两个下标相等时停止
            while (l<r && arr[l]<=stand) {//左标
                l++;
            }
            while (r>l && arr[r]>=stand) {//右标
                r--;
            }
            if(l<r){
                temp=arr[r];
                arr[r]=arr[l];
                arr[l]=temp;
            }
        }
        if(l!=right){
            //arrs[l]和标准位进行交换
            arr[right]=arr[l];
            arr[l]=stand;
        }
        kuaishu(arr,left,l-1);
        kuaishu(arr,r+1,right);

    }
    /*冒泡*/
    public static void maopao(int[] arr){
        int temp=0;
        /*冒泡排序*/
        for(int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    /*选择*/
    public void xuanze(int[] arr){
        int temp=0;
        int sprn=0;
        /*选择排序*/
        for (int i=0;i<arr.length-1;i++){
            temp=i;
            for (int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[temp]){
                    temp=j;
                }
            }
            sprn = arr[i];
            arr[i] = arr[temp];
            arr[temp] = sprn;
        }
    }
    /*插值*/
    public void chazhi(int[] arr){
        int temp=0;
        /*插值排序 arr[0];*/
        for (int i=1;i<arr.length;i++){
            for (int j=i;j-1>=0&&arr[j]<arr[j-1];j--){
                temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
            }
        }
    }
}
