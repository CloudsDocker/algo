package com.todzhang;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by todzhang on 2017/1/8.
 */
public class RemoveDupItemFromSortedArrayTest {
    @org.junit.Test
    public void removeDup() throws Exception {
        RemoveDupItemFromSortedArray inst=new RemoveDupItemFromSortedArray();
        assertEquals(inst.removeDup(new int []{1,2,2,5,7,9,9}),5);
    }

}