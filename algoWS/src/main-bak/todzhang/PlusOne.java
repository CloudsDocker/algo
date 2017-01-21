package com.todzhang;

/**
 * Created by todzhang on 2017/1/12.
 */
public class PlusOne {
    public static int[] plusOne(int[] ary){
        for (int i=ary.length-1;i>=0;i--){
            if(ary[i]!=9){
                ary[i]++;
                break;
            }
            else
            {
                ary[i]=0;
            }
        }

        // this means the input is all 9999, so just create a new array, and first digit is 1
        if(ary[0]==0){
            int[] res=new int[ary.length+1];
            res[0]=1;return res;
        }
        return ary;
    }
}
