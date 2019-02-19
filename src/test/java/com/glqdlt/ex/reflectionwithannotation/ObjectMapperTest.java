package com.glqdlt.ex.reflectionwithannotation;

import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author glqdlt
 * 2019-02-19
 */
public class ObjectMapperTest {

    @Test
    public void consume_간단한테스트() throws Exception {
//
//        List<SimpleObject> _dummy = IntStream.rangeClosed(1, 10).boxed()
//                .map(x -> {
//                    SimpleObject simpleObject = new SimpleObject();
//                    simpleObject.setDateType(new Date());
//                    simpleObject.setIntegerType(x);
//                    simpleObject.setIntType(x);
//                    simpleObject.setLongType((long) x);
//                    simpleObject.setLongObjectType((long) x);
//                    simpleObject.setStringType("string" + x);
//                    return simpleObject;
//                }).collect(Collectors.toList());
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.consume(_dummy);
    }
}