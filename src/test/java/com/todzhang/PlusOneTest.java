package com.todzhang;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by todzhang on 2017/1/12.
 */
public class PlusOneTest {
    @org.junit.Test
    public void plusOne() throws Exception {
        Assert.assertArrayEquals(PlusOne.plusOne(new int[]{1,2}),new int[]{1,3});
        Assert.assertArrayEquals(PlusOne.plusOne(new int[]{1,9}),new int[]{2,0});
        Assert.assertArrayEquals(PlusOne.plusOne(new int[]{9,9}),new int[]{1,0,0});
    }

}