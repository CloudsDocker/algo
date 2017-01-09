package com.todzhang;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by todzhang on 2017/1/9.
 */
public class RemoveDupItemFromSortedArrayLargerThan2Test {
    @org.junit.Test
    public void removeDupItemsForTwoOccurance() throws Exception {

        RemoveDupItemFromSortedArrayLargerThan2 inst =new RemoveDupItemFromSortedArrayLargerThan2();
        assertEquals(inst.removeDupItemsForTwoOccurance(new int[]{1,2,2,2,5,9,9,10,15,15,15,15,20}),10);
    }

}