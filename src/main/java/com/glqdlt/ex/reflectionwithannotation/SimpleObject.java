package com.glqdlt.ex.reflectionwithannotation;

import lombok.Data;

import java.util.Date;

/**
 * @author glqdlt
 * 2019-02-19
 */
public class SimpleObject {

    @IndexAnnotation
    private String stringType;

    @IndexAnnotation
    private Integer integerType;
    @IndexAnnotation(getMethodNamePrefix = "pipe")
    private int intType;
    public String pipeIntType(){
        int _t = this.intType;
        switch (_t){
            case 0:
                return "zero";
            case 1:
                return "one";
            default:
                return String.valueOf(_t);
        }
    }

    private long longType;

    @IndexAnnotation
    private Long longObjectType;
    @IndexAnnotation
    private Date dateType;
    @IndexAnnotation(getMethodNamePrefix = "is")
    private boolean used;
    @IndexAnnotation(parseSkip = true)
    private String skip;

    @IndexAnnotation
    private String notMethod;
}
