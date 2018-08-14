package com.zhangsan.test;


import javafx.scene.shape.Path;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Create with www.dezhe.com
 *
 * @Author 德哲
 * @Date 2018/8/14 8:26
 */
public class Demo {

    public static void main(String[] args) {

        //用面向对象的方法求出数组中重复 value 的个数，按如下个数输出：
        //1 出现： 1 次
        //3 出现： 2 次
        //8 出现： 3 次
        //2 出现： 4

        int arr[] = {1,4,1,4,2,5,4,5,8,7,8,77,88,5,4,9,6,2,4,1,5};

        MyArray myArray = new MyArray();
        myArray.getCout(arr);


    }


}
class MyArray{

    public void getCout(int[] array) {

        // 首先先让数组排序
        Arrays.sort(array);
        // 将数组以Key value的形式去储存
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 做标记 来记录次数
        int temp = 1;
        for (int i = 0; i < array.length; i++) {
            // 判断i 小于数组长度 防止越界  以及和 当前的i等于下一个i
            if (i < array.length - 1 && array[i] == array[i + 1] ){
                temp++;  // 进行++
            } else {
                // 如果不等的话 就直接储存
                map.put(array[i],temp);
                temp = 1;
                if (temp == array.length - 1) {   // 等于最后一个也进去存
                    map.put(array[i],temp);
                }
            }
        }

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();

        for (Map.Entry<Integer, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + " 出现 " +entry.getValue());

        }


    }


}
