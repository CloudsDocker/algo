package com.todzhang;

import org.junit.*;

import java.util.Arrays;

//import org.hamcrest.
public class arrayRemove {
    int removeLargerElement(int[] input, int threshold) {
        // try to find elements larger than the threshold, and remove those elements in place

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("test to remove elements > given value in place");
    }

    @org.junit.Test
    public void testRemoveLargerElement(){

        arrayRemove inst=new arrayRemove();
        Assert.assertEquals(inst.removeLargerElement(new int[]{1,2,3,5,2,2,7,9},2),5);

    }
}