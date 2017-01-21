package com.todzhang;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by todzhang on 2017/1/13.
 */
public class StreamTester {

    @org.junit.Test
    public static void testStream(){
        List<String> items= Stream.of("ab","b").collect(Collectors.toList());

    }
}
