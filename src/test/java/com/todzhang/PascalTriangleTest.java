package com.todzhang;

import org.junit.*;

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

    @org.junit.Test
    public void testPascalTriangleList(){
        PascalTriangle.getPascalTrigleList(5);
    }

}