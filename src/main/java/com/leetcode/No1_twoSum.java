package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No1_twoSum {
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target=9;
        int[] result=twoSum(nums,target);
        System.out.println(Arrays.toString(result));

        double i=9;
        int p=9;
        float u=9;
    }

    public static int[] twoSum(int[] nums,int target){
        int[] result=new int[2];
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        for (int i=0;i<nums.length;++i){
            int complement=target-nums[i];
            if (map.containsKey(complement)){
                result[1]=i;
                result[0]=map.get(complement);
            }
            map.put(nums[i],i);
        }
        return result;
    }
//wrong
//    public static int[] twoSum(int[] nums,int target){
//        int[] result=new int[2];
//        Map<Integer,Integer> hmap=new HashMap<Integer, Integer>() ;
//        for(int i=0;i<nums.length;++i){
//            if (!hmap.containsKey(nums[i])){
//                hmap.put(nums[i],i);//value,index
//            }
//            if (hmap.containsKey(target-nums[i])){
//                int index1=hmap.get(target-nums[i]);
//                int index2=i;
//                result[0]=index1;
//                result[1]=index2;
//            }
//        }
//        return  result;
//    }
}
