package com.todzhang;

import org.junit.*;

import java.util.*;

//import java.util.function.Predicate;

import static org.junit.Assert.*;

/**
 * Created by todzhang on 2017/1/12.
 */
public class PascalTriangleTest {
    @org.junit.Test
    public void genPascalTriangle() throws Exception {

        int[][] test=PascalTriangle.genPascalTriangle(5);
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[i].length; j++) {
                if(test[i][j]!=0) {
                    System.out.print("[" + test[i][j] + "]");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }

//    Predicate<Integer> atLeast5= x -> x>5;

    @org.junit.Test
    public void testPascalTriangleList(){
        List<List<Integer>> list= PascalTriangle.getPascalTrigleList(5);

//        list.forEach();
        final int[] ary={2,5};
        ThreadLocal tl=new ThreadLocal();

        for (List<Integer> item: list
             ) {
            for (Integer i:item
                 ) {

                System.out.print(i);
            }
            System.out.print("\n");
        }
    }

}